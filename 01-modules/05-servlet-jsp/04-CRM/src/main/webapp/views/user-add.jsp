<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row bg-title">
			<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
				<h4 class="page-title">
					<c:choose>
						<c:when test="${isEdit}">Sửa thông tin thành viên</c:when>
						<c:otherwise>Thêm mới thành viên</c:otherwise>
					</c:choose>
				</h4>
			</div>
		</div>
		<!-- /.row -->
		<!-- .row -->
		<div class="row">
			<div class="col-md-2 col-12"></div>
			<div class="col-md-8 col-xs-12">
				<div class="white-box">
					<c:if test="${param.created == '1'}">
						<p class="alert alert-success">Thêm thành viên thành công.</p>
					</c:if>
					<c:if test="${not empty error}">
						<p class="alert alert-danger">${error}</p>
					</c:if>
					<c:choose>
						<c:when test="${isEdit}">
							<c:url var="actionForm" value="user-edit"></c:url>
						</c:when>
						<c:otherwise>
							<c:url var="actionForm" value="user-add"></c:url>
						</c:otherwise>
					</c:choose>
					<form
						class="form-horizontal form-material"
						method="post"
						action="${actionForm}"
					>

						<c:if test="${isEdit}">
							<input
								type="hidden"
								name="id"
								value="${userEdit.id}"
							/>
						</c:if>
						<div class="form-group">
							<label class="col-md-12">Full Name</label>
							<div class="col-md-12">
								<input
									type="text"
									placeholder="Johnathan Doe"
									name="fullname"
									class="form-control form-control-line"
									value="${isEdit ? userEdit.fullname : param.fullname}"
								/>
							</div>
						</div>
						<div class="form-group">
							<label for="example-email" class="col-md-12">Email</label>
							<div class="col-md-12">
								<input
									type="email"
									placeholder="johnathan@admin.com"
									class="form-control form-control-line" name="email"
									value="${isEdit ? userEdit.email : param.email}"
									id="email"
								/>
							</div>
						</div>
						<c:if test="${not isEdit}">
							<div class="form-group">
								<label class="col-md-12">Password</label>
								<div class="col-md-12">
									<input
										type="password"
										name="password"
										class="form-control form-control-line"
									/>
								</div>
							</div>
						</c:if>

						<div class="form-group">
							<label class="col-md-12">Phone No</label>
							<div class="col-md-12">
								<input
									type="text"
									name="phone"
									value="${isEdit ? userEdit.phone : param.phone}"
									placeholder="123 456 7890"
									class="form-control form-control-line"
								/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-12">Role</label>
							<div class="col-md-12">
								<select name="roleId">
									<c:forEach items="${roles}" var="role">
										<option <c:if test="${(isEdit ? userEdit.roleId : param.roleId) == role.id}"> selected</c:if>
											value="${role.id}"
										>
											${role.nameRole}
										</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-12">Select Country</label>
							<div class="col-sm-12">
								<select class="form-control form-control-line" name="country">
									<option
										<c:if test="${(isEdit ? userEdit.country : param.country) == 'London'}"> selected</c:if>
										value="London"
									>
										London
									</option>
									<option
										<c:if test="${(isEdit ? userEdit.country : param.country) == 'India'}"> selected</c:if>
										value="India"
									>
										India
									</option>
									<option
										<c:if test="${(isEdit ? userEdit.country : param.country) == 'Usa'}"> selected</c:if>
										value="Usa"
									>
										Usa
									</option>
									<option
										<c:if test="${(isEdit ? userEdit.country : param.country) == 'Canada'}"> selected</c:if>
										value="Canada"
									>
										Canada
									</option>
									<option
										<c:if test="${(isEdit ? userEdit.country : param.country) == 'Thailand'}"> selected</c:if>
										value="Thailand"
									>
										Thailand
									</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<button type="submit" class="btn btn-success">
									<c:choose>
										<c:when test="${isEdit}">Update</c:when>
										<c:otherwise>Add new user</c:otherwise>
									</c:choose>
								</button>
								<a href="user-table.html" class="btn btn-primary">Quay lại</a>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="col-md-2 col-12"></div>
		</div>
		<!-- /.row -->
	</div>
</div>
