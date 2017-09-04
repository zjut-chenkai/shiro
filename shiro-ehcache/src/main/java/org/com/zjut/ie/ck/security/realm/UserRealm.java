package org.com.zjut.ie.ck.security.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public class UserRealm extends AuthorizingRealm {


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	System.out.println("进入UserRealm中doGetAuthorizationInfo方法22222222222");
        String username = (String)principals.getPrimaryPrincipal();
        
        Set<String> roles = new HashSet<String>();
        roles.add("admin");
        
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        
        Set<String> permissions = new HashSet<String>();
        permissions.add("resource:*");
        permissions.add("role:*");
        permissions.add("user:*");
        permissions.add("organization:*");
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

    	System.out.println("进入UserRealm中doGetAuthenticationInfo方法111111111111");
        String username = (String)token.getPrincipal();

        //浜ょ粰AuthenticatingRealm浣跨敤CredentialsMatcher杩涜�?�嗙爜鍖归厤锛屽鏋滆寰椾汉�?�剁殑涓嶅ソ鍙互鑷畾涔夊疄鐜�?
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                "admin", //鐢ㄦ埛鍚�?
                "d3c59d25033dbf980d29554025c23a75", //瀵嗙�?
                ByteSource.Util.bytes("admin"+"8d78869f470951332959580424d4bf4f"),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
