## car insurance online merchandise

| 所属表格 | role | password | 首页 |
|--------|------|----------|-----|
| t_admin  | 管理员 | admin / admin | houtai/adminMain |
| t_yonghu | 业务员 | yewuyuan1 / yewuyuan1 | houtai/ |
| t_user | 客户 | yonghu1 / yonghu1 | houtai/userMain | 

修复任务
==admin管理员==
- [x] 用户信息
    -  [x] 区域信息
    -  [x] 用户信息
- [ ] 业务员信息
    - [ ] 业务员信息
- [ ] 车辆信息
    - [ ] 车辆类型
    - [ ] 车辆信息
- [ ] 报价信息
    -  [ ] 报价信息
- [ ] 交流下单
    -  [ ] 交流信息
    -  [ ] 下单信息

==yonghu业务员==

==user客户==

t_yonghu
<table id="dg" title="<%=newJcpeizhi.getYonghuBieming()%>信息" class="easyui-datagrid" fitColumns="true"
    pagination="true" url="../getYonghus" fit="true" rownumbers="true" toolbar="#tb">
    <thead>
        <tr>
            <th field="cb" checkbox="true"></th>
            <th field="yonghuid" width="10" hidden="true">编号</th>
            <th field="yonghuname" width="20">登录名</th>
            <th field="yonghupassword" width="10" hidden="true">密码</th>
            <th field="yonghuxingming" width="20">姓名</th>
            <th field="yonghusex" width="10" formatter="formatSex">性别</th>
            <th field="yonghuage" width="10">年龄</th>
            <th field="yonghuphone" width="40">电话</th>
            <th field="yonghumark1" width="40">公司</th>
            <th field="buzhiid" width="10" hidden="true"><%=newJcpeizhi.getBuzhiBieming()%>ID</th>
            <th field="buzhiname" width="20"><%=newJcpeizhi.getBuzhiBieming()%></th>
            <th field="yonghudate" width="20" formatter="datetostr">时间</th>
        </tr>
    </thead>
</table>

```
PeizhiPojo newJcpeizhi = (PeizhiPojo)session.getAttribute("jcpeizhi");
UserPojo user = (UserPojo)session.getAttribute("user");
int buzhiId = user.getBuzhiid();
int userId = user.getUserid();

String title = newJcpeizhi.getShujubieming();
String shaochu = newJcpeizhi.getSjshaochubieming();
String jianchu = newJcpeizhi.getSjjianchubieming();
String douchu  = newJcpeizhi.getSjduochubieming();
String username = newJcpeizhi.getUserBieming();
String yonghu = newJcpeizhi.getYonghuBieming();
```

### reference

https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-view-jsp