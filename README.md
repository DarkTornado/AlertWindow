# AlertWindow

© 2017 Dark Tornado, All rights reserved.

Customizing this class(?) as changing color, texts, size...etc, is allowed.
In service, we cannot use PopupWindow or AlertDialog.Builder.
So, AlertWindow uses WindowManager.

색상이나 문구, 크기 등을 수정하는 행위는 서용되어 있습니다.
서비스에서는 팝업 윈도우나 다이얼로그를 사용할 수 기 때문에, AlertWindow는 WindowManager를 사용합니다.



You can set title and put message as AlertDialog.<br>
다이얼로그처럼 제목과 메시지 설정 가능.<br>
<img src="https://raw.githubusercontent.com/DarkTornado/AlertWindow/master/Example_Image_2.png" width="360">

Also, you can set view to it. ScrollView will be automatically added.\n
뷰 설정도 가능. 세로 스크롤뷰는 자동으로 추가됨.\n
<img src="https://raw.githubusercontent.com/DarkTornado/AlertWindow/master/Example_Image_3.png" width="360">


- new AlertWindow(Context ctx);\n
ctx is context of app. You can use this or getApplicationContext(). ctx는 앱의 context값. this나 getApplicationContext()라고 적으면 됨.

- new AlertWindow(Context ctx);<br>
ctx is context of app. You can use this or getApplicationContext(). ctx는 앱의 context값. this나 getApplicationContext()라고 적으면 됨.


