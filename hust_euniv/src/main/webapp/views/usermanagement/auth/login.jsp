<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Thông tin đăng nhập</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" name="form" action="<c:url value="/j_spring_security_check" />" method="POST">
                            <fieldset>
                            	<c:if test="${1 == failed}">
							        <div class="has-error">
							        	<span class='help-block form-error' style="text-align: center;">Thông tin đăng nhập không chính xác.<br> Vui lòng thử lại !</span>
							        </div>
							    </c:if>
                                <div class="form-group">
									<input class="form-control" type="text" name="j_username"  value="" placeholder="Tên đăng nhập" autofocus />
                                </div>
                                <div class="form-group">
                                	<input class="form-control" type="password" name="j_password"  placeholder="Mật khẩu" />
                                </div>
                                <!-- <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>-->
                                <!-- Change this to a button or input when using this as a form -->
                                <input class="btn btn-lg btn-success btn-block" name="submit" type="submit" value="Đăng nhập"/>
                                <!-- <span>Nếu chưa có tài khoản, <a href="${baseUrl}/auth/register.html">Đăng ký</a></span>-->
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

