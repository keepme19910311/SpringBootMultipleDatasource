<@com.head title="">
    <base id="base" href="${basePath!}">
    <link href="${basePath!}/static/plugins/layui/css/layui.css" type="text/css" media="screen" rel="stylesheet"/>
    <script src="${basePath!}/static/plugins/layui/layui.js" type="text/javascript"></script>

    <script>
        //一般直接写在一个js文件中
        layui.use(['layer', 'form', 'table'], function () {
            var layer = layui.layer
                , form = layui.form
                , $ = layui.$
                , laytpl = layui.laytpl
                , table = layui.table;
            // 第一个数据库
            var tableUserLogin = table.render({
                id: 'userLoginTableId'
                , elem: '#UserLoginTable'
                , height: 460
                , width: 755
                , url: '${basePath!}/jtaTest/queryUserLogin' //数据接口
                , page: true //开启分页
                , cols: [[ //表头
                    {type: 'numbers', title: '序号', width: 80}
                    , {field: 'loginUid', title: '主键', width: 300}
                    , {field: 'loginName', title: '登录名', width: 200}
                    , {width: 170, title: '操作', align: 'center', toolbar: '#barDemo'} //这里的toolbar值是模板元素的选择器
                ]],
                method: 'post',
                request: {
                    pageName: 'page' //页码的参数名称，默认：page
                    , limitName: 'rows' //每页数据量的参数名，默认：limit
                },
                response: {
                    statusName: 'code'
                    , statusCode: 0
                    , countName: 'total' //数据总数的字段名称，默认：count
                    , dataName: 'list' //数据列表的字段名称，默认：data
                },
            });

            var UserLoginInsertLayerIndex;

            //新建
            $("#UserLoginInsert").click(function () {
                //置空表单
                $("#UserLoginInsertForm").find(":input[name='loginName']").val("");
                $("#UserLoginInsertForm").find(":input[name='loginUid']").val("");
                UserLoginInsertLayerIndex = layer.open({
                    title: "新建",
                    type: 1,
                    content: $('#UserLoginInsertDiv')
                });
            });

            form.on('submit(UserLoginInsertFormSubmit)', function (data) {
                $.ajax({
                    type: "POST",
                    url: "${basePath!}/jtaTest/saveOrUpdateUserLogin",
                    data: $("#UserLoginInsertForm").serialize(),
                    async: false,
                    error: function (request) {
                        layer.alert("与服务器连接失败/(ㄒoㄒ)/~~");
                        return false;
                    },
                    success: function (data) {
                        if (data.state == 'fail') {
                            layer.alert(data.message);
                            layer.close(UserLoginInsertLayerIndex);
                            return false;
                        } else if (data.state == 'success') {
                            layer.alert(data.message);
                            layer.close(UserLoginInsertLayerIndex);
                            tableUserLogin.reload({
                                page: {
                                    curr: 1 //重新从第 1 页开始
                                }
                            });
                        }
                    }
                });
                return false; //这个阻止表单跳转。如果需要表单跳转， 去掉这段即可。
            });

            //监听工具条
            table.on('tool(UserLoginTable)', function (obj) { //注：tool是工具条事件名，UserLogin是table原始容器的属性 lay-filter="对应的值"
                var data = obj.data; //获得当前行数据
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                if (layEvent === 'del') { //删除
                    layer.confirm('真的删除该行数据吗', function (index) {
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        //向服务端发送删除指令
                        $.ajax({
                            type: "POST",
                            url: "${basePath!}/jtaTest/deleteUserLogin",
                            data: {loginUid: data.loginUid},
                            async: false,
                            error: function (request) {
                                layer.alert("与服务器连接失败/(ㄒoㄒ)/~~");
                                return false;
                            },
                            success: function (data) {
                                if (data.state == 'fail') {
                                    layer.alert(data.message);
                                    return false;
                                } else if (data.state == 'success') {
                                }
                            }
                        });
                    });
                } else if (layEvent === 'edit') { //编辑
                    //置空表单
                    $("#UserLoginInsertForm").find(":input[name='loginName']").val("");
                    $("#UserLoginInsertForm").find(":input[name='loginUid']").val("");
                    //添加值
                    $("#UserLoginInsertForm").find(":input[name='loginName']").val(data.loginName);
                    $("#UserLoginInsertForm").find(":input[name='loginUid']").val(data.loginUid);
                    UserLoginInsertLayerIndex = layer.open({
                        title: "编辑",
                        type: 1,
                        content: $('#UserLoginInsertDiv')
                    });
                }
            });
            // 第二个数据库
            var tableNews = table.render({
                id: 'newsTableId'
                , elem: '#News'
                , height: 460
                , width: 755
                , url: '${basePath!}/jtaTest/selectNewsByPages' //数据接口
                , page: true //开启分页
                , cols: [[ //表头
                    {type: 'numbers', title: '序号', width: 80, sort: true}
                    , {field: 'newsId', title: '主键', width: 300, unresize: true}
                    , {field: 'newsTitle', title: '新闻标题', width: 200, unresize: true}
                    , {width: 170, title: '操作', align: 'center', toolbar: '#barDemo'} //这里的toolbar值是模板元素的选择器
                ]],
                method: 'post',
                request: {
                    pageName: 'page' //页码的参数名称，默认：page
                    , limitName: 'rows' //每页数据量的参数名，默认：limit
                },
                response: {
                    statusName: 'code'
                    , statusCode: 0
                    , countName: 'total' //数据总数的字段名称，默认：count
                    , dataName: 'list' //数据列表的字段名称，默认：data
                },
            });

            var NewsInsertLayerIndex;

            //新建
            $("#NewsInsert").click(function () {
                //置空表单
                $("#NewsInsertForm").find(":input[name='newsTitle']").val("");
                $("#NewsInsertForm").find(":input[name='newsId']").val("");
                NewsInsertLayerIndex = layer.open({
                    title: "新建",
                    type: 1,
                    content: $('#NewsInsertDiv')
                });
            });

            form.on('submit(NewsInsertFormSubmit)', function (data) {
                $.ajax({
                    type: "POST",
                    url: "${basePath!}/jtaTest/saveOrUpdateNews",
                    data: $("#NewsInsertForm").serialize(),
                    async: false,
                    error: function (request) {
                        layer.alert("与服务器连接失败/(ㄒoㄒ)/~~");
                        return false;
                    },
                    success: function (data) {
                        if (data.state == 'fail') {
                            layer.alert(data.message);
                            layer.close(NewsInsertLayerIndex);
                            return false;
                        } else if (data.state == 'success') {
                            layer.alert(data.message);
                            layer.close(NewsInsertLayerIndex);
                            tableNews.reload({
                                page: {
                                    curr: 1 //重新从第 1 页开始
                                }
                            });
                        }
                    }
                });

                return false; //这个阻止表单跳转。如果需要表单跳转， 去掉这段即可。
            });

            //监听工具条
            table.on('tool(News)', function (obj) { //注：tool是工具条事件名，UserLogin是table原始容器的属性 lay-filter="对应的值"
                var data = obj.data; //获得当前行数据
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                var tr = obj.tr; //获得当前行 tr 的DOM对象

                if (layEvent === 'detail') { //查看
                    //do somehing
                } else if (layEvent === 'del') { //删除
                    layer.confirm('真的删除该行数据吗', function (index) {
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        //向服务端发送删除指令
                        $.ajax({
                            type: "POST",
                            url: "${basePath!}/jtaTest/deleteNews",
                            data: {newsId: data.newsId},
                            async: false,
                            error: function (request) {
                                layer.alert("与服务器连接失败/(ㄒoㄒ)/~~");
                                return false;
                            },
                            success: function (data) {
                                if (data.state == 'fail') {
                                    layer.alert(data.message);
                                    return false;
                                } else if (data.state == 'success') {
                                }
                            }
                        });
                    });
                } else if (layEvent === 'edit') { //编辑
                    //do something
                    //置空表单
                    $("#NewsInsertForm").find(":input[name='newsTitle']").val("");
                    $("#NewsInsertForm").find(":input[name='newsId']").val("");
                    //添加值
                    $("#NewsInsertForm").find(":input[name='newsTitle']").val(data.newsTitle);
                    $("#NewsInsertForm").find(":input[name='newsId']").val(data.newsId);
                    NewsInsertLayerIndex = layer.open({
                        title: "编辑",
                        type: 1,
                        content: $('#NewsInsertDiv')
                    });
                }
            });

            //分布式事务测试
            $("#JTATest").click(function () {
                $.ajax({
                    type: "POST",
                    url: "${basePath!}/jtaTest/insertToTwoDatebase",
                    data: {},
                    async: false,
                    error: function (request) {
                        layer.alert("与服务器连接失败/(ㄒoㄒ)/~~");
                        return false;
                    },
                    success: function (data) {
                        if (data.state == 'fail') {
                            layer.alert(data.message);
                            return false;
                        } else if (data.state == 'success') {
                            layer.alert(data.message);
                        }
                    }
                });
            });


        });
    </script>
</@com.head>
<@com.body>
<#--第一个数据库表-->
    <fieldset class="layui-elem-field">
        <legend>用户登录信息</legend>
        <div class="layui-field-box">
            <div class="layui-fluid">
                <div class="layui-row">
                    <button class="layui-btn" id="UserLoginInsert">新建</button>
                </div>
                <div class="layui-row">
                    <table id="UserLoginTable" lay-filter="UserLoginTable"></table>
                </div>
            </div>
        </div>
    </fieldset>
    <div id="UserLoginInsertDiv" style="display: none">
        <form class="layui-form" action="" id="UserLoginInsertForm">
            <input type="hidden" id="UserLoginInsertFormId" name="loginUid"/>
            <div class="layui-form-item">
                <label class="layui-form-label">登录名</label>
                <div class="layui-input-block">
                    <input type="text" name="loginName" required lay-verify="required" placeholder="请输登陆名称"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="UserLoginInsertFormSubmit">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary" id="UserLoginInsertFormReset">重置</button>
                </div>
            </div>
        </form>
    </div>
<#--    第二个数据库表-->
    <fieldset class="layui-elem-field">
        <legend>新闻信息</legend>
        <div class="layui-field-box">
            <div class="layui-fluid">
                <div class="layui-row">
                    <button class="layui-btn" id="NewsInsert">新建</button>
                </div>
                <div class="layui-row">
                    <table id="News" lay-filter="News"></table>
                </div>
            </div>
        </div>
    </fieldset>
    <div id="NewsInsertDiv" style="display: none">
        <form class="layui-form" action="" id="NewsInsertForm">
            <input type="hidden" id="NewsInsertFormId" name="newsId"/>
            <div class="layui-form-item">
                <label class="layui-form-label">新闻标题</label>
                <div class="layui-input-block">
                    <input type="text" name="newsTitle" required lay-verify="required" placeholder="请输新闻标题"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="NewsInsertFormSubmit">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary" id="NewsInsertFormReset">重置</button>
                </div>
            </div>
        </form>
    </div>

<#------------------------------------>
    <fieldset class="layui-elem-field">
        <legend>分布式事务测试</legend>
        <div class="layui-field-box">
            <div class="layui-fluid">
                <div class="layui-row">
                    <button class="layui-btn" id="JTATest">同时向两个表内插入信息为8888的数据</button>
                </div>
            </div>
        </div>
    </fieldset>
    <script type="text/html" id="barDemo">
        <#--<a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>-->
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
    <!-- 序号监听事件 -->
    <script type="text/html" id="indexTpl">
        {{d.LAY_TABLE_INDEX+1}}
    </script>
</@com.body>