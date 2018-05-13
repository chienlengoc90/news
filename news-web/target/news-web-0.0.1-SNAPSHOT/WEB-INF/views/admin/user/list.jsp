<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="formUrl" value="/admin/news/list"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách bài viết</title>
</head>
<body>
<div class="main-content">
    <form:form commandName="model" action="${formUrl}" id="listForm" method="GET">
        <div class="main-content-inner">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Trang chủ</a>
                    </li>
                    <li class="active">Danh sách bài viết</li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <c:if test="${messageResponse!=null}">
                            <div class="alert alert-block alert-${alert}">
                                <button type="button" class="close" data-dismiss="alert">
                                    <i class="ace-icon fa fa-times"></i>
                                </button>
                                    ${messageResponse}
                            </div>
                        </c:if>
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12">
                                    <div class="widget-box table-filter">
                                        <div class="widget-header">
                                            <h4 class="widget-title">Tìm kiếm</h4>
                                            <div class="widget-toolbar">
                                                <a href="#" data-action="collapse">
                                                    <i class="ace-icon fa fa-chevron-up"></i>
                                                </a>
                                            </div>
                                        </div>
                                        <div class="widget-body">
                                            <div class="widget-main">
                                                <div class="form-horizontal">
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">Tên bài viết:</label>
                                                        <div class="col-sm-8">
                                                            <div class="fg-line">
                                                                <form:input path="title" cssClass="form-control input-sm"/>
                                                            </div>
                                                        </div>
                                                    </div>                                                   
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label"></label>
                                                        <div class="col-sm-8">
                                                            <button id="btnSearch" type="button" class="btn btn-sm btn-success">
                                                                Tìm kiếm
                                                                <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="table-btn-controls">
                                        <div class="pull-right tableTools-container">
                                            <div class="dt-buttons btn-overlap btn-group">                                              
                                                <a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                                    data-toggle="tooltip" title="Thêm bài viết mới" href='<c:url value="/admin/news/edit"/>'>
                                                    <span>
                                                    <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                </span>
                                                </a>
                                                <button type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
                                                        data-toggle="tooltip" title="Xóa bài viết">
                                                    <span>
                                                    <i class="fa fa-trash-o bigger-110 pink"></i>
                                                	</span>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-responsive">
                                        <display:table name="model.listResult" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                                       partialList="true" sort="external" size="${model.totalItems}" defaultsort="2" defaultorder="ascending"
                                                       id="tableList" pagesize="${model.maxPageItems}" export="false"
                                                       class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                                       style="margin: 3em 0 1.5em;">
                                            <display:column title="<fieldset class='form-group'>
												        <input type='checkbox' id='checkAll' class='check-box-element'>
												        </fieldset>" class="center select-cell"
                                                            headerClass="center select-cell">
                                                <fieldset>
                                                    <input type="checkbox" name="checkList" value="${tableList.id}" id="checkbox_${tableList.id}" class="check-box-element"/>
                                                </fieldset>                                              
                                            </display:column>
                                            <display:column headerClass="text-left" property="title" title="Tiêu đề"/>
                                            <display:column headerClass="text-left" property="view" title="Lượt xem"/>                                            
                                            <display:column headerClass="col-actions" title="Thao tác">                                               
                                                <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip" 
                                                	title="Cập nhật bài viết" href='<c:url value="/admin/news/${tableList.id}"/>'><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                                            </display:column>
                                        </display:table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $('#btnSearch').click(function () {
            $('#listForm').submit();
        });
    });
    <%-- function update(btn) {
        var url = $(btn).attr('sc-url');
        if(typeof url == "undefined"){
            url = '${ajaxAddEditUrl}'
        }
        $('#addModal').load(url,{},function () {
            $('#addModal').modal('toggle');
            registerSubmitPopup();
        });
    }
    function registerSubmitPopup() {
        $('#btnSave').click(function () {
            $('#editForm').submit();
        });
        $('#editForm').submit(function(e) {
            e.preventDefault();
            $("#crudactionEdit").val("insert-update");
            $.ajax({
                cache: false,
                type: "POST",
                dataType: "html",
                data: $(this).serialize(),
                url: $(this).attr('action'),
                success: function(res) {
                    if(res.trim() == '<%=Constant.REDIRECT_ERROR%>') {
                        $('#crudaction').val('<%=Constant.REDIRECT_ERROR%>');
                        $('#listForm').submit();
                    }else {
                        $("#addModal").html(res);
                        registerSubmitPopup();
                    }
                }
            });
        });
    }
    function warningBeforeDelete(id) {
        showAlertBeforeDelete(function () {
            if (id != undefined && id != "") {
                $(".check-box-element").prop('checked', false);
                var html = '<input type="hidden" value="' + id + '" name="checkList"/>';
                $('#deleteCurrentRole').append(html);
            }
            $('#crudaction').val('delete');
            $('#listForm').submit();
        });
    } --%>
</script>
</body>
</html>
