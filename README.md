# AlertWindow

© 2017 Dark Tornado, All rights reserved.

Customizing this class(?) as changing color, texts, size...etc, is allowed.<br>
In service, we cannot use PopupWindow or AlertDialog.Builder.<br>
So, AlertWindow uses WindowManager.<br><br>

색상이나 문구, 크기 등을 수정하는 행위는 서용되어 있습니다.<br>
서비스에서는 팝업 윈도우나 다이얼로그를 사용할 수 없기 때문에, AlertWindow는 WindowManager를 사용합니다.<br><br>


You can set title and put message as AlertDialog.<br>
다이얼로그처럼 제목과 메시지 설정 가능.<br>
<img src="https://raw.githubusercontent.com/DarkTornado/AlertWindow/master/Example_Image_2.png" width="360">

Also, you can set view to it. ScrollView will be automatically added.<br>
뷰 설정도 가능. 세로 스크롤뷰는 자동으로 추가됨.<br>
<img src="https://raw.githubusercontent.com/DarkTornado/AlertWindow/master/Example_Image_3.png" width="360">

###How to Use(?) 사용법(?)
Make a class named AlertWindow and Copt+Paste.<br>
AlertWindow라는 클래스 하나 만들고 소스 복사+붙여넣기 하시고 사용하시면 됩니다.<br>
<img src="https://raw.githubusercontent.com/DarkTornado/AlertWindow/master/Example_Image_4.png" width="560">
<br><br>


- <b>new AlertWindow(Context ctx);</b><br>
ctx is context of app. You can use this or getApplicationContext().<br>
ctx는 앱의 context값. this나 getApplicationContext()라고 적으면 됨.


- <b>.setTitle(String title);</b><br>
Set AlertWindow's title.<br>
AlertWindow의 타이틀 설정.

- <b>.setMessage(String msg);</b><br>
Set AlertWindow's message.<br>
AlertWindow의 메시지 설정.


- <b>.setView(View view);</b><br>
Set AlertWindow's view. I recommend use LinearLayout as a parameter.<br>
AlertWindow의 뷰 설정. LinearLayout을 매개변수로 사용하는 것을 추천.

- <b>.useCloseButton(boolean use);</b><br>
Select using X button or not. Defualt is true.<br>
X버튼을 사용할지 말지 결정. 기본값은 true.

- <b>.setButton(String txt, View.OnClickListener listener);</b><br>
Set Button to AlertWindow like NegativeButton from AlertDialog.<br>
AlertDialog에 있는 부정 버튼과 같은 버튼을 AlertWindow에 설정.

- <b>.show();</b><br>
Show the AlertWindow<br>
AlertWindow 출력.

- <b>.close();</b><br>
Close the AlertWindow<br>
AlertWindow 삭제.


