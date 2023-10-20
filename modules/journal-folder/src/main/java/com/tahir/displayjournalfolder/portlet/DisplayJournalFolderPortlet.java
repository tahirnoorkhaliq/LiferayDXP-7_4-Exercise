package com.tahir.displayjournalfolder.portlet;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.model.JournalFolderConstants;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.service.JournalFolderLocalService;
import com.liferay.portal.kernel.bean.BeanParamUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.WindowStateFactory;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.trash.TrashHelper;
import com.tahir.displayjournalfolder.constants.DisplayJournalFolderPortletKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Tahir Noor Khaliq
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DisplayJournalFolder", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DisplayJournalFolderPortletKeys.DISPLAYJOURNALFOLDER,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.show-portlet-access-denied=false" }, service = Portlet.class)
public class DisplayJournalFolderPortlet extends MVCPortlet {

	@Reference
	private TrashHelper _trashHelper;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		_httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		ThemeDisplay _themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String foldersAndArticlesJson = getFoldersJSONArray(_themeDisplay,renderRequest, renderResponse).toString();
		List<JournalArticle> ja = journalArticleLocalService.getArticles();
		for (JournalArticle journalArticle : ja) {
			System.out.println("Title: "+journalArticle.getTitle());
			
		}
		System.out.println("==========================");
		System.out.println(foldersAndArticlesJson);
		renderRequest.setAttribute("data", foldersAndArticlesJson);
		super.doView(renderRequest, renderResponse);
	}

	public JSONArray getFoldersJSONArray(ThemeDisplay _themeDisplay,RenderRequest renderRequest,RenderResponse renderResponse) {
		return JSONUtil.put(JSONUtil.put("children", getFoldersJSONArrayRec(_themeDisplay.getScopeGroupId(),
				JournalFolderConstants.DEFAULT_PARENT_FOLDER_ID, renderRequest, renderResponse)));
	}

	private JSONArray getFoldersJSONArrayRec(long groupId, long folderId,RenderRequest renderRequest,RenderResponse renderResponse) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		try {
			List<Object> folders = journalFolderLocalService.getFoldersAndArticles(groupId, folderId);

			for (Object folderOrArticle : folders) {

				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				if (folderOrArticle instanceof JournalFolder) {
					JournalFolder curFolder = (JournalFolder) folderOrArticle;
					JSONArray childrenJSONArray = getFoldersJSONArrayRec(groupId, curFolder.getFolderId(), renderRequest, renderResponse);

					if (childrenJSONArray.length() > 0) {
						jsonObject.put("children", childrenJSONArray);
					}
					
					jsonObject.put("id", curFolder.getFolderId()).put("label", curFolder.getName());
				} else {
					JournalArticle article = (JournalArticle) folderOrArticle;
					// String content = HtmlParserUtil.extractText(article.getContent());
					long rpk = article.getResourcePrimKey();
					AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry("com.liferay.journal.model.JournalArticle",rpk);
					AssetRenderer<?> assetRenderer = assetEntry.getAssetRenderer();
					PortletURL redirectURL =  renderResponse.createRenderURL();
					PortletURL editPortletURL = null;
					try {
						 editPortletURL = assetRenderer.getURLEdit((LiferayPortletRequest) renderRequest,(LiferayPortletResponse) renderResponse,
								WindowStateFactory.getWindowState("maximized"),redirectURL);
						System.out.println("editPortletURL : "+editPortletURL);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					JournalArticleDisplay jarticleDispaly = JournalArticleLocalServiceUtil.getArticleDisplay(groupId,
							article.getArticleId(), "", "en_US", null);
					if (Validator.isNotNull(jarticleDispaly)) {
						System.out.println("Content: " + jarticleDispaly.getContent());
						
						System.out.println("URl===="+jarticleDispaly.getUrlTitle());
						jsonObject.put("id", article.getArticleId()).put("label", article.getTitle())
								.put("content", "Title is "+article.getTitle()+" Content is "+jarticleDispaly.getContent().trim()).put("article", true).put("uri",editPortletURL);
					}
				}

				jsonArray.put(jsonObject);
				// JournalArticle article = (JournalArticle)folderOrArticle;
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonArray;
	}

	public long getParentFolderId() {
		if (_parentFolderId != null) {
			return _parentFolderId;
		}

		_parentFolderId = ParamUtil.getLong(_httpServletRequest, "parentFolderId",
				JournalFolderConstants.DEFAULT_PARENT_FOLDER_ID);

		return _parentFolderId;
	}

	public long getFolderId() {
		if (_folderId != null) {
			return _folderId;
		}

		_folderId = BeanParamUtil.getLong(getFolder(), _httpServletRequest, "folderId",
				JournalFolderConstants.DEFAULT_PARENT_FOLDER_ID);

		return _folderId;
	}

	public JournalFolder getFolder() {
		if (_folder != null) {
			return _folder;
		}

		_folder = (JournalFolder) _httpServletRequest.getAttribute(WebKeys.JOURNAL_FOLDER);

		if (_folder != null) {
			return _folder;
		}

		_folder = journalFolderLocalService.fetchFolder(ParamUtil.getLong(_httpServletRequest, "folderId"));

		return _folder;
	}

	private JournalFolder _folder;
	private Long _parentFolderId;
	private HttpServletRequest _httpServletRequest;
	private Long _folderId;

	@Reference
	JournalFolderLocalService journalFolderLocalService;
	@Reference
	JournalArticleLocalService journalArticleLocalService;
}
