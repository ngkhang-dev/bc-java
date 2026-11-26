$(document).ready(function () {
  $("#btn-login").click(function (e) {
    e.preventDefault();

    var ipEmail = $("#lg-email").val();
    var ipPassword = $("#lg-password").val();

    var requestData = {
      email: ipEmail,
      password: ipPassword,
    };

    $.ajax({
      url: "http://localhost:8080/auth/sign-in",
      type: "POST",
      contentType: "application/json",
      dataType: "json",
      data: JSON.stringify(requestData),

      beforeSend: function () {
        $("#btn-login").prop("disabled", true);
        console.log("Sending login request...");
      },

      success: function (response) {
        console.log("Login success:", response);

        // Ví dụ xử lý access token
        // localStorage.setItem('accessToken', response.data.accessToken);

        alert("Login successful!");
      },

      error: function (xhr, status, error) {
        console.log("Status:", xhr.status);
        console.log("Response:", xhr.responseJSON);

        var errorMessage = "Login failed!";

        if (xhr.responseJSON && xhr.responseJSON.message) {
          errorMessage = xhr.responseJSON.message;
        }

        alert(errorMessage);
      },

      complete: function () {
        $("#btn-login").prop("disabled", false);
      },
    });
  });
});
