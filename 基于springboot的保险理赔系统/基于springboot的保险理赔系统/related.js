$(function () {
    layui.use('form', function () {
        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function (data) {

            // $('#admin').val(3)
            if ($('#Iid').val() == '' || $('#Iid').val() == null) {
                $.ajax({
                    type: "get",
                    url: "http://127.0.0.1:8083/user/insertInsAndMark",
                    data: data.field,
                    async: true,
                    dataType: "json",
                    success: function (result) {
                        console.log(result);
                        alert("提交成功");
                    }
                })
            } else {
                $.ajax({
                    type: "get",
                    url: "http://127.0.0.1:8083/user/updateInsAndMark",
                    data: data.field,
                    async: true,
                    dataType: "json",
                    success: function (result) {
                        console.log(result);
                        alert("提交成功");
                    }
                })
            }
            // location.reload();
            return false;
        });


        /*form.on('select(filter)', function (data) {
            // console.log(data.elem); //得到select原始DOM对象
            // console.log(data.value); //得到被选中的值
            $.ajax({
                type: "get",
                url: "http://127.0.0.1:8083/user/selectByUserid",
                data: {userId: data.value},
                async: true,
                dataType: "json",
                success: function (result) {
                    console.log(result);
                    if (result.insuranceId != null || result.insuranceId != '') {
                        form.val("form", result)
                    } else {
                        console.log(data.value);
                        form.val("form", result)
                    }
                }
            })
            // console.log(data.othis); //得到美化后的DOM对象
        });*/
    });

    // $.ajax({
    //     type: "get",
    //     url: "http://127.0.0.1:8083/user/queryAllByLimit",
    //     data: {page: 1, limit: 100},
    //     async: true,
    //     dataType: "json",
    //     success: function (result) {
    //         console.log(result);
    //         var li = ' <select lay-filter="filter"  name="userId" lay-verify="required">';
    //         for (var i = 0; i < result.data.length; i++) {
    //             li += ' <option value=' + result.data[i].id + '>' + result.data[i].name + '</option>\n'
    //         }
    //         li+='</select>';
    //         $('#user').append(li)
    //     }
    // })

})

//获取url中"?"符后的字串
function GetRequest() {
    var url = location.search;
    url = decodeURI(url);
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        var strs = str.split("&");

        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}

var request = new Object();
request = GetRequest(); // GetRequest();
var pid = request['patid'];
$('#patid').val(pid);

layui.use('table', function () {
    var table = layui.table;
    // var laydate = layui.laydate;

    //时间戳的处理
    layui.laytpl.toDateString = function (d, format) {
        var date = new Date(d || new Date())
            , ymd = [
            this.digit(date.getFullYear(), 4)
            , this.digit(date.getMonth() + 1)
            , this.digit(date.getDate())
        ]
            , hms = [
            this.digit(date.getHours())
            , this.digit(date.getMinutes())
            , this.digit(date.getSeconds())
        ];

        format = format || 'yyyy-MM-dd  ';

        return format.replace(/yyyy/g, ymd[0])
            .replace(/MM/g, ymd[1])
            .replace(/dd/g, ymd[2])
            .replace(/HH/g, hms[0]);
    };

    //数字前置补零
    layui.laytpl.digit = function (num, length, end) {
        var str = '';
        num = String(num);
        length = length || 2;
        for (var i = num.length; i < length; i++) {
            str += '0';
        }
        return num < Math.pow(10, length) ? str + (num | 0) : num;
    };

    var tableIns = table.render({
        elem: '#news'
        , url: 'http://127.0.0.1:8083/user/queryAllByLimit'
        , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        , defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示'
            , layEvent: 'LAYTABLE_TIPS'
            , icon: 'layui-icon-tips'
        }]
        , title: '用户列表'
        , cols: [[
            , {field: 'name', title: '姓名', edit: 'text', sort: true}
            , {field: 'sex', title: '性别', edit: 'text', sort: true}
            , {field: 'hometown', title: '籍贯', edit: 'text', sort: true}
            , {
                field: 'birthday',
                title: '出生日期',
                templet: '<div>{{ layui.laytpl.toDateString(d.birthday) }}</div>',
                sort: true
            }
            , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 240}
        ]]
        , page: true
        , id: "testReload"
    });
    tableIns.reload({
        where: {
            'pid': pid
        }
    })





    //头工具栏事件
    table.on('toolbar(news)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'getCheckData':
                var data = checkStatus.data;
                layer.alert(JSON.stringify(data));
                break;
            case 'getCheckLength':
                var data = checkStatus.data;
                layer.msg('选中了：' + data.length + ' 个');
                break;
            case 'isAll':
                layer.msg(checkStatus.isAll ? '全选' : '未全选');
                break;
            //自定义头工具栏右侧图标 - 提示
            case 'LAYTABLE_TIPS':
                layer.alert('这是工具栏右侧自定义的一个图标按钮');
                break;
        }
        ;
    });


    table.on('edit(news)', function (obj) { //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
        console.log(obj.value); //得到修改后的值
        console.log(obj.field); //当前编辑的字段名
        console.log(obj.data); //所在行的所有相关数据
        edit(obj)
    });
    //监听行工具事件
    table.on('tool(news)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('真的删除么', function (index) {
                obj.del();
                console.log(index)
                del(data.id)
                layer.close(index);

            });
        } else if (obj.event === 'edit') {
            $.ajax({
                type: "get",
                url: "http://127.0.0.1:8083/user/selectByUserid",
                data: "userId=" + data.id,
                async: true,
                dataType: "json",
                success: function (result) {
                    var form = layui.form;
                    console.log(result);
                    form.val("form", result);
                }
            })
        }
    });
});
