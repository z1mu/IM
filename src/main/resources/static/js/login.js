function getImgCode() {
    $.get("/zimu/getImgCode", function (imgCode) {
        $('#imgCode').attr('src', imgCode);
    });
}