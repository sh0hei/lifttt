// トップへ戻る
$(function () {
    $.scrollUp({
        scrollText: "",
    });
});

ias = $.ias({
  container: ".timeline",
  item: ".item",
  pagination: "#pagination",
  next: ".next a"
});

ias.extension(new IASSpinnerExtension({src: 'loading.gif'}));
ias.extension(new IASNoneLeftExtension({text: 'There are no more pages left to load.'}));

// navber固定用
var nav    = $('#nav'),
    offset = nav.offset();

$(window).scroll(function () {
  if($(window).scrollTop() > offset.top) {
    nav.addClass('fixed');
  } else {
    nav.removeClass('fixed');
  }
});
