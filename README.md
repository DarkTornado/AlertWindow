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
<br><br>
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
<br><br>

## API

#### new AlertWindow(Context ctx);
* `ctx` is Context of app. You can use `thi`s or `getApplicationContext()`.
* `ctx`는 앱의 Context값. `this`나 `getApplicationContext()`라고 적으면 됨.

#### new AlertWindow(Context ctx, boolean hasEditText);
* If you want to input any value to EditText in AlertWindow, you should set hasEditText true. If hasEditText is true, you cannot touch AlertWindow's outside, but, you can touch when it is foldeded.
* 만약, AlertWindow에 있는 EditText에 값을 입력하고 싶다면, hasEditText를 true로 설정해야 함. hasEditText가 true이면 AlertWindow의 밖을 터치할 수 없으나, 접은 상태에서는 터치 가능.


#### .setTitle(String title);
* Set AlertWindow's title.
* AlertWindow의 타이틀 설정.

#### .setMessage(String msg);
* Set AlertWindow's message.
* AlertWindow의 메시지 설정.

#### .setView(View view);
* Set AlertWindow's view. I recommend using LinearLayout as a parameter.
* AlertWindow의 뷰 설정. LinearLayout을 매개변수로 사용하는 것을 추천.

#### .useCloseButton(boolean use);
* Select using X button or not. Defualt is true.
* X버튼을 사용할지 말지 결정. 기본값은 true.

#### .setButton(String txt, View.OnClickListener listener);
* Set Button to AlertWindow like NegativeButton from AlertDialog.
* AlertDialog에 있는 부정 버튼과 같은 버튼을 AlertWindow에 설정.

#### .show();
* Show the AlertWindow
* AlertWindow 출력.

#### .close();
* Close the AlertWindow
* AlertWindow 삭제.

#### .setDraggable(boolean canDrag);
* If canDrag is true, you can move the AlertWindow's position by dragging its title. Defualt is true.
* AlertWindow의 타이틀 부분을 길게 눌러서 이동시킬 수 있도록 할지 설정. 기본값은 true.

#### .setFoldable(boolean canFold);
* If canFold is true, you can fold the AlertWindow by touching its title. Defualt is false.
* AlertWindow의 타이틀 부분을 길게 눌러서 접을 수 있도록 할지 설정. 기본값은 false.

