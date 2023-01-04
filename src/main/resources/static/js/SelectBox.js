"use strict";
$(function () {
  $("#bigCategory").change(function () {
    let id = $("#bigCategory").val();
    $("#mediumCategory > option").remove();

    $.ajax({
      url: "http://localhost:8080/add/mediumcategory",
      type: "POST",
      dataType: "json",
      data: {
        id: id,
      },
      async: true,
    }).done(function (mediumCategoryList) {
      for (let i = 0; i < mediumCategoryList.length; i++) {
        $("#mediumCategory").append(
          $("<option>")
            .html(mediumCategoryList[i].name)
            .val(mediumCategoryList[i].id)
        );
      }
    });
  });

  $("#mediumCategory").change(function () {
    let id = $("#mediumCategory").val();
    $("#smallCategory > option").remove();

    $.ajax({
      url: "http://localhost:8080/add/smallcategory",
      type: "POST",
      dataType: "json",
      data: {
        id: id,
      },
      async: true,
    }).done(function (smallCategoryList) {
      for (let i = 0; i < smallCategoryList.length; i++) {
        $("#smallCategory").append(
          $("<option>")
            .html(smallCategoryList[i].name)
            .val(smallCategoryList[i].id)
        );
      }
    });
  });
});
