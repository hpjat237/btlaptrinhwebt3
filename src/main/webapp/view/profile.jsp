<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="main">
    <div class="container">
        <div class="col-md-12 col-sm-12">
            <h1>My account</h1>
            <div class="content-form-page">
                <div class="row">
                    <div class="col-md-7 col-sm-7">
                        <form action="/profile" method="post" class="form-horizontal" role="form">
                            <fieldset>
                                <legend>Your personal details</legend>
                                <div class="form-group">
                                    <label for="username" class="col-lg-4 control-label">Username <span
                                            class="require">*</span></label>
                                    <div class="col-lg-8">
                                        <input type="text" class="form-control" value="${username}" id="uname"
                                               name="uname">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="username" class="col-lg-4 control-label">Fullname <span
                                            class="require">*</span></label>
                                    <div class="col-lg-8">
                                        <input type="text" class="form-control" value="${fullname}" id="fname"
                                               name="fname">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="phone" class="col-lg-4 control-label">Phone <span
                                            class="require">*</span></label>
                                    <div class="col-lg-8">
                                        <input type="text" class="form-control" value="${phone}" id="phn"
                                               name="phn">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="email" class="col-lg-4 control-label">Email <span
                                            class="require">*</span></label>
                                    <div class="col-lg-8">
                                        <input type="email" class="form-control" value="${email}" id="eml"
                                               name="eml">
                                    </div>
                                </div>
                            </fieldset>
                            <fieldset>
                                <legend>Your password</legend>
                                <div class="form-group">
                                    <label for="password" class="col-lg-4 control-label">Password <span class="require">*</span></label>
                                    <div class="col-lg-8">
                                        <input type="password" class="form-control" id="password" name="psw">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="confirm-password" class="col-lg-4 control-label">Confirm password <span
                                            class="require">*</span></label>
                                    <div class="col-lg-8">
                                        <input type="password" class="form-control" id="cf-psw"
                                               name="cf-psw">
                                    </div>
                                </div>
                            </fieldset>
                            <div class="row">
                                <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
                                    <button type="submit" class="btn btn-primary">Update</button>
                                    <button type="button" class="btn btn-default">Cancel</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="col-md-5 col-sm-5 pull-right">
                        <div class="form-info">
                            <h2><em>Upload</em> Avatar</h2>
                            <form action="/upload" method="post" enctype="multipart/form-data" class="form-horizontal">
                                <div class="form-group">
                                    <label for="file" class="col-lg-4 control-label">Choose file <span
                                            class="require">*</span></label>
                                    <div class="col-lg-8">
                                        <input type="file" class="form-control" name="file" id="file" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
                                        <button type="submit" class="btn btn-primary">Upload</button>
                                    </div>
                                </div>
                            </form>
                            <c:if test="${not empty message}">
                                <div class="alert alert-info">${message}</div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>