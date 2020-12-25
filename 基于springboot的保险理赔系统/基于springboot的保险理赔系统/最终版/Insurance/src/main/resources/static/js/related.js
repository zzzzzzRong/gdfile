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
                    }
                })
            }
             location.reload();
            return false;
        });


        form.on('select(filter)', function (data) {
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
        });
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
