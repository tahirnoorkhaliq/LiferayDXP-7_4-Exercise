<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tahir.displayjournalfolder.constants.MenuItem"%>
<%@page import="java.util.List"%>
<%@ include file="./init.jsp" %>
<style>
ul, .myUL {
  list-style-type: none;
}

.myUL {
  margin: 0;
  padding: 0;
}

.caret {
  cursor: pointer;
  -webkit-user-select: none; /* Safari 3.1+ */
  -moz-user-select: none; /* Firefox 2+ */
  -ms-user-select: none; /* IE 10+ */
  user-select: none;
}

.caret::before {
  content: "\25B6";
  color: black;
  display: inline-block;
  margin-right: 6px;
}

.caret-down::before {
  -ms-transform: rotate(90deg); /* IE 9 */
  -webkit-transform: rotate(90deg); /* Safari */'
  transform: rotate(90deg);  
}

.nested {
  display: none;
}

.active {
  display: block;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<portlet:resourceURL var="exportCSVResourceUrl" id="/journal/export/csv"/>
<div class="d-flex justify-content-center">
	<div class="col-sm-10">
	<p>Journal Article Tree</p>
		<div id="myTreeView"></div>
	</div>
	<div class="col-sm-2">
		<button class="export-csv" >Export</button>
	</div>
</div>




<script type="text/javascript">
$( document ).ready(function() {
 
var jsonTreeData=[];
jsonTreeData=JSON.parse('${data}');
console.log(jsonTreeData);
function createTreeView(node, data,classnm) {
	  const ul = $('<ul class="'+classnm+'">');

	  data.forEach(item => {
	    const li = $('<li>');
	   
	    if(item.article){
	    	const label= $('<label>').text(item.content);
	    	 const checkbox = $('<input type="checkbox">').attr('name', 'node-checkbox').attr('class', 'ckb-node').attr('article', item.article).val(item.id);
	 	    li.append(checkbox, label);
	    }else{
	    	const label= $('<label>').text(item.label);
	    	 const checkbox = $('<input type="checkbox">').attr('name', 'node-checkbox').attr('class', 'ckb-node').attr('article', item.article).val(item.id);
	 	    li.append(checkbox, label);
	    }	    
	   

	    if (item.children && item.children.length > 0) {
	      const childUl = createTreeView(li, item.children,'nested');
	      li.append(childUl);
	    }

	    ul.append(li);
	  });

	  node.append(ul);
	  return ul;
	}

	
	  const treeviewDiv = $('#myTreeView');
	  createTreeView(treeviewDiv, jsonTreeData, 'myUL');
	  $('.nested').closest('li').children('label').addClass('caret');
	  $('label.caret').click(function(){
			$(this).next('ul').toggle();
			return false;
		});
	  var ids=[];
	  $('input[name*=node-checkbox]').change(function() {
		   ids=[];
	        console.log(this.checked); 
	        if(this.checked) {
	        	//ids.push($(this).val());
	        $(this).closest('li').find('ul input[name*=node-checkbox]').each(function() {
	        	 console.log('foreach');
	        	$(this).prop('checked', true);
	        	if($(this).attr('article')== true || $(this).attr('article')== 'true'){
	        		ids.push($(this).val());	
	        	}
	        	
	        });
	        }else{
	        	 $(this).closest('li').find('ul input[name*=node-checkbox]').prop('checked', false);
	        }
	    });
	  
	  $(".export-csv").click(function(){
			console.log("exportCSV"+ids);
	      AUI().use('aui-io-request', function (A) {
	          A.io.request('${exportCSVResourceUrl}', {
	              method: 'post',
	              data: {
	                  <portlet:namespace/>journalIds: ids,
	              },
	              on: {
	                  success: function () {
	                      alert(this.get('responseData'));
	                  }

	              }
	          });
	      });
	  });

});

</script>