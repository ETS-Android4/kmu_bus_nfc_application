package com.example.busapplication;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
public class CustomDialogRead extends Activity {
    private String Title;
    private String Content;
    private Context context;

    public CustomDialogRead(String Title,String Content,Context context) {
        this.context = context;
        this.Title = Title;
        this.Content=Content;
    }

    // 호출할 다이얼로그 함수를 정의한다.
    public void callFunction() {

        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        final Dialog dlg = new Dialog(context);

        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.custom_dialog_read);

        // 커스텀 다이얼로그를 노출한다.
        dlg.show();

        // 커스텀 다이얼로그의 각 위젯들을 정의한다.
        final TextView message = (TextView) dlg.findViewById(R.id.mesgase);
        final TextView title = (TextView) dlg.findViewById(R.id.TTtitle);
        final Button okButton = (Button) dlg.findViewById(R.id.okButton);

        title.setMovementMethod(ScrollingMovementMethod.getInstance());

        message.setMovementMethod(new ScrollingMovementMethod());


        title.setText(Title);
        message.setText(Content);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // '확인' 버튼 클릭시 메인 액티비티에서 설정한 main_label에
                // 커스텀 다이얼로그에서 입력한 메시지를 대입한다.
                // 커스텀 다이얼로그를 종료한다.
                dlg.dismiss();
            }
        });
    }
}
