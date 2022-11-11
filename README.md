# AlertWindow

© 2017 Dark Tornado, All rights reserved.

* Customizing source as changing color, texts, size...etc, is allowed.
* `AlertWindow` is made with `WindowManager` because we cannot use `PopupWindow` or `AlertDialog` in `Service`.
* It needs `android.permission.SYSTEM_ALERT_WINDOW`.
* If you want to use as PopupWindow, please reference [FloatingWindow](https://github.com/DarkTornado/FloatingWindow).
<br><br>
* 색상이나 문구, 크기 등을 수정하는 행위는 허용되어 있습니다.
* 서비스에서는 팝업 윈도우나 다이얼로그를 사용할 수 없기 때문에, `AlertWindow`는 `WindowManager`로 구현되어 있습니다.
* `android.permission.SYSTEM_ALERT_WINDOW` 권한이 필요합니다.
* 만약, `PopupWindow`처럼 사용하는 것을 원한다면, [FloatingWindow](https://github.com/DarkTornado/FloatingWindow)을 참고해주세요.

## Intro.
* You can set title and put message as `AlertDialog`.
* 다이얼로그처럼 제목과 메시지 설정 가능.
<img src="https://raw.githubusercontent.com/DarkTornado/AlertWindow/master/Example_Image_2.png" width="360">
<br><br>

* Also, you can set view to it. ScrollView will be automatically added.
* 뷰 설정도 가능. 세로 스크롤뷰는 자동으로 추가됨.

<img src="https://raw.githubusercontent.com/DarkTornado/AlertWindow/master/Example_Image_3.png" width="360">
<br><br>

## How to Use / 사용법
* Make a class named `AlertWindow` and Copy+Paste.
* `AlertWindow`라는 클래스 하나 만들고 소스 복사+붙여넣기 하시고 사용하시면 됩니다.
<img src="https://raw.githubusercontent.com/DarkTornado/AlertWindow/master/Example_Image_4.png" width="720">
<br>

## Docs

[Click Here to move](https://darktornado.github.io/libdocs/docs/AlertWindow/)
