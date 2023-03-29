package com.laison.softwareproject.common.utils;


import com.laison.softwareproject.common.constants.ConfigConstant;
import com.laison.softwareproject.model.sys.SysUser;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.List;

public class LoginUserUtil {

    /**
     * 获取登陆的 LoginAppUser
     *
     * @return
     */
//	@SuppressWarnings("rawtypes")
//	public static LoginAppUser getLoginAppUser() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication instanceof OAuth2Authentication) {
//			OAuth2Authentication oAuth2Auth = (OAuth2Authentication) authentication;
//			authentication = oAuth2Auth.getUserAuthentication();
//			if (authentication instanceof UsernamePasswordAuthenticationToken) {
//				UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) authentication;
//				Object principal = authentication.getPrincipal();
//				if (principal instanceof LoginAppUser) {
//					return (LoginAppUser) principal;
//				}
//				Map map = (Map) authenticationToken.getDetails();
//				map = (Map) map.get("principal");
//				return JsonUtils.jsonToPojo(JsonUtils.objectToJson(map), LoginAppUser.class);
//			}else if(authentication instanceof SocialAuthenticationToken){
//				Object principal = authentication.getPrincipal();
//				if (principal instanceof LoginAppUser) {
//					return (LoginAppUser) principal;
//				}
//			}
//		}
//		return null;
//	}

//	public static SysUser getSysUser(Boolean... isThrowExcption) throws Exception{
//
//		Boolean throwExcption=isThrowExcption==null||isThrowExcption.length==0||isThrowExcption[0];
//		LoginAppUser loginAppUser = getLoginAppUser();
//		if(loginAppUser ==null ) {
//			if(throwExcption) {
//				throw new Exception(ContentConstant.PLEASE_LOGIN);
//			}
//			return null;
//
//		}
////		SysUserService sysUserService = SpringContextUtils.getBean(SysUserService.class);
////		try {
////			SysUser sysUser = sysUserService.selectByPrimaryKey(loginAppUser.getId());
////			sysUser.setLanguage(getLanguage(sysUser.getUsername()));
////			return sysUser;
////		} catch (Exception e) {
////			e.printStackTrace();
////			if(throwExcption) {
////				throw new Exception(ContentConstant.PLEASE_LOGIN);
////			}
////			return null;
////		}
//
//	}

    /**
     * 更新权限
     *
     * @throws Exception
     */
//	public static void updateAuthorities() {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		//List<GrantedAuthority> updatedAuthorities =
//		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
//		List<GrantedAuthority> updatedAuthorities = new ArrayList<GrantedAuthority>(authorities);
//
//		if ( auth instanceof OAuth2Authentication) {
//			Object principal = auth.getPrincipal();
//			if (principal instanceof LoginAppUser) {
//				LoginAppUser	loginAppUser=(LoginAppUser) principal;
//				updatedAuthorities.clear();
//				Set<String> permissions = new HashSet<String>();
//
//				if(loginAppUser.getId().equals("1")) {
//
//
//					SysMenuService sysMenuService = SpringContextUtils.getBean(SysMenuService.class);
//					List<String> authoritys = sysMenuService.findAllAuthoritys();
//					permissions.addAll(authoritys);
//
//
//				}else {
//					SysUserDao sysUserDao = SpringContextUtils.getBean(SysUserDao.class);
//					List<String> authoritys =sysUserDao.findUserAuthoritys(loginAppUser.getId());
//					permissions.addAll(authoritys);
//				}
//
//				Collection<GrantedAuthority> collection = new HashSet<>();
//				if (!CollectionUtils.isEmpty(permissions)) {
//					permissions.forEach(per -> {
//						collection.add(new SimpleGrantedAuthority(per));
//					});
//				}
//				updatedAuthorities.addAll(collection);
//			}
//		}
//		//AuthenticationManager authenticationManager = SpringContextUtils.getBean(AuthenticationManager.class);
//
//
//		Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), updatedAuthorities);
//
//		String clientId ="system";
//		OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) auth.getDetails();
//
//		ClientDetails clientDetails = SpringContextUtils.getBean(RedisClientDetailsService.class).loadClientByClientId(clientId);
//
//		TokenRequest tokenRequest = new TokenRequest(new HashMap<String, String>(), clientId, clientDetails.getScope(),
//				"password");
//
//		OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);
//
//		OAuth2Authentication oAuth2Authentication = new MyHelpAuthentication(details.getTokenValue(),oAuth2Request, newAuth);
//		//OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, newAuth);
//
//		SpringContextUtils.getBean(AuthorizationServerTokenServices.class).createAccessToken(oAuth2Authentication);
//
//
//	}
    public static String getLanguage() {
//        SysUser sysUser = getSysUser();
//        if (sysUser != null) {
//            return sysUser.getLanguage();
//        }
        return ConfigConstant.I18N;
    }
//
//    public static String getTimeZone() {
//        SysUser sysUser = getSysUser();
//        if (sysUser != null) {
//            return sysUser.getSysDept().getConfig().getTimeZone();
//        }
//        return null;
//    }
//
//    public static void changeLanguage(String language) {
//        if (I18NResourceBundleUtils.contains(language)) {
//            SysUser sysUser = getSysUser();
//            SysUser updateUser = new SysUser();
//            updateUser.setId(sysUser.getId());
//            updateUser.setLanguage(language);
//            SysUserService sysUserService = SpringContextUtils.getBean(SysUserService.class);
//            try {
//                sysUserService.updateByPrimaryKey(updateUser);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            sysUser.setLanguage(language);
//        }
//
//    }
//
//    public static void updateQuickEntry(String quickEntry) {
//        //接收的字符串为修改后的值，应当被写入数据库
//        //获取用户id
//        try {
//            SysUser sysUser = getSysUser();
//            SysUser updateUser = new SysUser();
//            updateUser.setId(sysUser.getId());
//            updateUser.setQuickEntry(quickEntry);
//
//            SysUserService sysUserService = SpringContextUtils.getBean(SysUserService.class);
//            sysUserService.updateByPrimaryKey(updateUser);
//
////				sysUser.setQuickEntry(quickEntry);
//
//
////				SysUser sysUserUpdate = new SysUser().setId(sysUser.getId()).setPassword(sysUser.getPassword());
////				sysUserDao.updateByPrimaryKeySelective(sysUserUpdate);
//            SpringContextUtils.getCache(SysUserService.CACHE_NAME).evict(sysUser.getId());
//            SpringContextUtils.getCache(SysUserService.BRIEF_CACHE_NAME).evict(sysUser.getId());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
////		if(I18NResourceBundleUtils.contains(language)) {
////			SysUser sysUser = getSysUser();
////			SysUser updateUser = new SysUser();
////			updateUser.setId(sysUser.getId());
////			updateUser.setLanguage(language);
////			SysUserService sysUserService = SpringContextUtils.getBean(SysUserService.class);
////			try {
////				sysUserService.updateByPrimaryKey(updateUser);
////			} catch (Exception e) {
////				e.printStackTrace();
////			}
////			sysUser.setLanguage(language);
////		}
//
//    }
//
//    public static String ALL_TYPE = "ALL";  //全部数据
//    public static String NORMAL_TYPE = "NORMAL_TYPE";  //正常的2级隔离
//    public static String SUB_DEPT_TYPE = "SUB_DEPT_TYPE";  //获取自己及子部门的
//    public static String SCHEME_TYPE = "SCHEME_TYPE";  //从部门配置里获取部门的方案隔离级别
//    public static String CUSTOMER_TYPE = "CUSTOMER_TYPE";  //从部门配置里获取部门的客户（表计）隔离级别
//
//    public static void addIsolate(Example example) {
//        addIsolate(example, NORMAL_TYPE);
//    }
//
//    public static void addIsolate(Example example, String type) {
//        try {
//            SysUser sysUser = getSysUser();
//            if (sysUser != null) {
//                List<Criteria> oredCriteria = example.getOredCriteria();
//                Criteria criteria = null;
//                if (!CollectionUtils.isEmpty(oredCriteria)) {
//                    criteria = oredCriteria.get(0);
//                }
//                List<String> sysDeptIds = null;
//                if (type.equals(NORMAL_TYPE)) {
//                    sysDeptIds = sysUser.getSysDeptIds();
//                } else if (type.equals(SUB_DEPT_TYPE)) {
//                    sysDeptIds = sysUser.getSubDeptIds();
//                } else if (type.equals(SCHEME_TYPE)) {
//                    sysDeptIds = sysUser.selectSchemeDeptIds();
//                } else if (type.equals(CUSTOMER_TYPE)) {
//                    sysDeptIds = sysUser.selectCustomerDeptIds();
//                }
//                if (criteria == null) {
//                    criteria = example.createCriteria();
//                    criteria.andIn("deptId", sysDeptIds);
//                    example.and(criteria);
//                    return;
//                }
//                criteria.andIn("deptId", sysDeptIds);
//                return;
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
    public static SysUser getSysUser() {
//        return MyContextHolder.getContext().getSysUser();
        return null;
    }


	public static void addIsolate(Example example) throws Exception {
//		SysUser sysUser = getSysUser(false);
//		if(sysUser==null) {
//			return ;
//		}
		Criteria criteria = example.createCriteria();
//		criteria.andIn("deptId", sysUser.getSysDeptIds());
		example.and(criteria);
	}

}
