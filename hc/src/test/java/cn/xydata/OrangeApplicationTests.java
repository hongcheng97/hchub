package cn.xydata;

import cn.xydata.entity.system.Permission;
import cn.xydata.entity.system.RolePermission;
import cn.xydata.entity.system.User;
import cn.xydata.mapper.system.PermissionMapper;
import cn.xydata.mapper.system.RolePermissionMapper;
import cn.xydata.mapper.system.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrangeApplicationTests {

	@Autowired
	private PermissionMapper permissionMapper;

	@Autowired
	private RolePermissionMapper rolePermissionMapper;

	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {


		Example example = new Example(User.class);
		Example.Criteria c = example.createCriteria();
		c.andEqualTo("username","admin");

		User user = userMapper.selectByExample(example).get(0);

		Permission p1 = new Permission();
		p1.setPermName("Dashboard");
		p1.setImageUrl("laptop");
		p1.setPageUrl("/dashboard");
		p1.setRank(0);
		permissionMapper.insert(p1);

		RolePermission rolePermission1 = new RolePermission();
		rolePermission1.setPermId(p1.getId());
		rolePermission1.setRoleId(user.getRoleId());
		rolePermissionMapper.insert(rolePermission1);


		Permission p2 = new Permission();
		p2.setPermName("资源投入");
		p2.setImageUrl("camera-o");
		p2.setBreadId(p1.getId());
		p2.setPageUrl("/control");
		p2.setRank(0);

		permissionMapper.insert(p2);

		RolePermission rolePermission2 = new RolePermission();
		rolePermission2.setPermId(p2.getId());
		rolePermission2.setRoleId(user.getRoleId());
		rolePermissionMapper.insert(rolePermission2);

		Permission p3 = new Permission();
		p3.setPermName("资源管理");
		p3.setImageUrl("user");
		p3.setBreadId(p1.getId());
		p3.setRank(0);

		permissionMapper.insert(p3);

		RolePermission rolePermission3 = new RolePermission();
		rolePermission3.setPermId(p3.getId());
		rolePermission3.setRoleId(user.getRoleId());
		rolePermissionMapper.insert(rolePermission3);

		Permission p4 = new Permission();
		p4.setPermName("项目管理");
		p4.setImageUrl("appstore-o");
		p4.setPageUrl("/project");
		p4.setBreadId(p1.getId());
		p4.setRank(0);

		permissionMapper.insert(p4);

		RolePermission rolePermission4 = new RolePermission();
		rolePermission4.setPermId(p4.getId());
		rolePermission4.setRoleId(user.getRoleId());
		rolePermissionMapper.insert(rolePermission4);

		Permission p5 = new Permission();
		p5.setPermName("产品体系");
		p5.setImageUrl("tag-o");
		//p5.setPageUrl("/product");
		p5.setBreadId(p1.getId());
		p5.setRank(0);
		permissionMapper.insert(p5);

		RolePermission rolePermission5 = new RolePermission();
		rolePermission5.setPermId(p5.getId());
		rolePermission5.setRoleId(user.getRoleId());
		rolePermissionMapper.insert(rolePermission5);

		Permission p6 = new Permission();
		p6.setPermName("资源组织");
		p6.setImageUrl("database");
		p6.setPageUrl("/resource/organization");
		p6.setBreadId(p3.getId());
		p6.setParentId(p3.getId());
		p6.setRank(0);

		permissionMapper.insert(p6);
		RolePermission rolePermission6 = new RolePermission();
		rolePermission6.setPermId(p6.getId());
		rolePermission6.setRoleId(user.getRoleId());
		rolePermissionMapper.insert(rolePermission6);

		Permission p7 = new Permission();
		p7.setPermName("资源架构");
		p7.setImageUrl("pushpin-o");
		p7.setPageUrl("/resource/people");
		p7.setBreadId(p3.getId());
		p7.setParentId(p3.getId());
		p7.setRank(0);

		permissionMapper.insert(p7);
		RolePermission rolePermission7 = new RolePermission();
		rolePermission7.setPermId(p7.getId());
		rolePermission7.setRoleId(user.getRoleId());
		rolePermissionMapper.insert(rolePermission7);

		Permission p9 = new Permission();
		p9.setPermName("产品管理");
		p9.setImageUrl("tag-o");
		p9.setPageUrl("/product");
		p9.setBreadId(p5.getId());
		p9.setParentId(p5.getId());
		p9.setRank(0);
		permissionMapper.insert(p9);

		RolePermission rolePermission9 = new RolePermission();
		rolePermission9.setPermId(p9.getId());
		rolePermission9.setRoleId(user.getRoleId());
		rolePermissionMapper.insert(rolePermission9);

		Permission p10 = new Permission();
		p10.setPermName("产品族管理");
		p10.setImageUrl("tag-o");
		p10.setPageUrl("/cluster");
		p10.setBreadId(p5.getId());
		p10.setParentId(p5.getId());
		p10.setRank(0);
		permissionMapper.insert(p10);

		RolePermission rolePermission10 = new RolePermission();
		rolePermission10.setPermId(p10.getId());
		rolePermission10.setRoleId(user.getRoleId());
		rolePermissionMapper.insert(rolePermission10);

		Permission p8 = new Permission();
		p8.setPermName("产品详情");
		p8.setParentId("-1");
		p8.setBreadId(p9.getId());
		p8.setPageUrl("/product/:id");
		p8.setRank(0);

		permissionMapper.insert(p8);
		RolePermission rolePermission8 = new RolePermission();
		rolePermission8.setPermId(p8.getId());
		rolePermission8.setRoleId(user.getRoleId());
		rolePermissionMapper.insert(rolePermission8);


		Permission p11 = new Permission();
		p11.setPermName("组织架构");
		p11.setImageUrl("tag-o");
		p11.setPageUrl("/resource/arch");
		p11.setBreadId(p3.getId());
		p11.setParentId(p3.getId());
		p11.setRank(0);
		permissionMapper.insert(p11);

		RolePermission rolePermission11 = new RolePermission();
		rolePermission11.setPermId(p11.getId());
		rolePermission11.setRoleId(user.getRoleId());
		rolePermissionMapper.insert(rolePermission11);

	}

}
