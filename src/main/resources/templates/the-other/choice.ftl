$(function () {
        $("#notice").mouseover(function () {
            $("#notice_bot").show();
        });
        $("#notice").mouseleave(function () {
            $("#notice_bot").hide();
        });
        $("#textSubmit").click(function () {
            var textField = $("#textfield1").val();
            window.location.href = "${ctx}/policy/badcreditpayment/applyPage.do?keyword=" + textField;
        });

        var jsonArr, insId, policyId, amountFlg, sumAmount, amountRemind;
        jsonArr = [];
        amountFlg = false;
        sumAmount = 0;

        //已经提交过的数据置为不可选
        $(".policy_input_money").each(function (i, n) {
            if ($(n).val() > 0) {
                $(n).closest("tr").find("input[type='checkbox']").prop("checked", false).attr("readonly", true).attr("disabled", true).addClass("input_disabled")
                    .siblings("label").addClass("input_disabled").val(parseFloat($(n).closest("tr").find("input[type='checkbox']")).toString());
                $(n).attr("readonly", true).addClass("input_disabled");
            }
        });

        $("#submit").click(function () {
            policyId = $("#table_1 input:checked").attr("policyId");//
            if ("" == policyId || policyId == undefined) {
                layer.alert("请选择风险补偿政策", {icon: 1, title: '温馨提示'});
                return null;
            }

            insId = $(".insId").text();
            console.log("开始遍历");
            if (null==$(".checkBuss")||0==$(".checkBuss").size()) {
                layer.alert("请到平台备案您的放款数据", {
                    icon: 1,
                    title: "温馨提示"
                    , time: 0
                    , btn: ['确认']
                    , yes: function (index, layero) {
                        amountFlg = false;
                        layer.close(index);
                    }
                });
                return null;
            }
            $(".checkBuss").each(function (i, n) {
                if ($(n).attr("checked") == "checked" && $(n).attr("readonly") != "readonly") {
                    var releaseInfoId = $(n).closest("tr").find("td:first span:last").text();
                    var paymentAmount = $(n).closest("tr").find("td:last :input").val();
                    jsonArr.push({
                        "policyId": policyId + "",
                        "insId": insId + "",
                        "releaseInfoId": releaseInfoId + "",
                        "paymentAmount": paymentAmount + ""
                    });
                }
            });

            $(jsonArr).each(function (i, n) {
                if ("NaN" == n.paymentAmount || null == n.paymentAmount || "" == n.paymentAmount|| n.paymentAmount <= 0 || n.paymentAmount > 10000000000) {
                    jsonArr = [];
                    sumAmount = 0;
                    amountFlg = true;
                    amountRemind = '请检查您想补偿的金额';
                    return null;
                }else if (!((n.paymentAmount+"").match(/^\d+(\.\d+)?$/))) {
                    jsonArr = [];
                    sumAmount = 0;
                    amountFlg = true;
                    amountRemind = '请检查您输入的金额格式';
                    return null;
                }
                sumAmount = sumAmount + parseFloat(n.paymentAmount);
            });

            if (amountFlg) {
                layer.alert(amountRemind, {
                    icon: 1,
                    title: "温馨提示"
                    , time: 0
                    , btn: ['确认']
                    , yes: function (index, layero) {
                        amountFlg = false;
                        layer.close(index);
                    }
                });
                return null;
            }
            console.log(jsonArr);

            if (jsonArr.length == 0) {
                layer.alert("请选择您要补偿的放款", {icon: 1, title: '温馨提示'});
                return null;
            } else {
                var policy = 1 == policyId ? "深圳市中小微企业贷款风险补偿金申请" : 2 == policyId ? "深圳市中小微企业动产融资贷款风险补偿申请" : null;
                if (null == policy) {
                    layer.alert("未知错误请联系管理员", {icon: 1, title: '温馨提示'});
                    return null;
                }
                layer.confirm('<p style="font-weight: bold;">请确认本次政策申报信息：</p>' +
                    '&nbsp;&nbsp;&nbsp;&nbsp;申报政策：&nbsp;' + policy + '</br>' +
                    '&nbsp;&nbsp;&nbsp;&nbsp;申报业务：&nbsp;<font color="blue"> ' + jsonArr.length + '</font>笔</br>' +
                    '&nbsp;&nbsp;&nbsp;&nbsp;申请总金额：&nbsp;<font color="blue">' + sumAmount + '</font>元。</br>', {
                    icon: 1,
                    title: '温馨提示'
                    , btn: ['确定', '取消']//按钮
                }, function (index) {
                    layer.close(index);
                    //此处请求后台程序，下方是成功后的前台处理……
                    var index = layer.load(0, {shade: [0.7, '#393D49']}, {shadeClose: true}); //0代表加载的风格，支持0-2
                    $.ajax({
                        url: "${ctx}/policy/badcreditpayment/putApply.do",
                        type: "POST",
                        dataType: "json",
                        data: {"jsonStr": JSON.stringify(jsonArr)},
                        success: function (data) {
                            if (data.code == "S000") {
                                layer.alert('恭喜您，政策申报成功。</br>' +
                                    '接下来请在政务大厅提交政策申报资料。</br>', {
                                    closeBtn: 1    // 是否显示关闭按钮
                                    , anim: 1 //动画类型
                                    , icon: 6    // icon
                                    , title: "温馨提示"
                                    , yes: function () {
                                        window.location.href = "${ctx}/policy/badcreditpayment/policy_list.do";
                                    }
                                })
                            } else {
                                layer.alert('操作失败，请联系管理员！', {
                                    time: 0
                                    , btn: ['确认']
                                    , icon: 1
                                    , title: "温馨提示"
                                    , yes: function (index, layero) {
                                        window.location.reload(true);
                                    }
                                })
                            }
                        }
                    });
                }, function (index) {
                    layer.close(index);
                    jsonArr = [];
                    sumAmount = 0;
                });
            }

        })
    })