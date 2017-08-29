/**
 项目JS主入口
 以依赖Layui的layer和form模块为例
 **/
layui.define(['layer', 'form'], function (exports) {
    var layer = layui.layer;
    var form = layui.form;

    layer.msg('Hello World');

    $('#_form').ajax({
        url: '/api/role/list',
        type: 'post',
        dataType: 'json',
        target: '',
        clearForm: false,
        restForm: false,
        timeout: 30000,
        beforeSubmit: function (formData, jqForm, options) {
            var userIdLt = $("textarea").val();
            var reg = /(\d[1,10],)*(\d{1,10})$/;
            if (userIdLt != null && userIdLt != "" && !reg.test(userIdLt)) {
                layer.msg('用户编号格式错误', {offset: 0, shift: 0});
                return false;
            }
            return true;
        },
        success: function (responseText, statusText, xhr, $form) {

        },
        error: function (xhr, statusText, error) {
            var status = xhr.status;
            layer.msg('系统异常[' + status + ']', {icon: 5});
        }
    });

    exports('role', {}); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});