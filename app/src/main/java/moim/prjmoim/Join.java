package moim.prjmoim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Join extends AppCompatActivity {

    static EditText etName1, etId1, etPwd1, etPwdCheck1, etPhone1, etEmail1;
    Button btCheck1, btJoin2, btCancel1;
    static String sName1, sId1, sPwd1, sPwdCheck1, sPhone1, sEmail1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        etName1 = findViewById(R.id.etName1);
        etId1 = findViewById(R.id.etId1);
        etPwd1 = findViewById(R.id.etPwd1);
        etPwdCheck1 = findViewById(R.id.etPwdCheck1);
        etPhone1 = findViewById(R.id.etPhone1);
        etEmail1 = findViewById(R.id.etE_mail1);

        btJoin2 = findViewById(R.id.btJoin2);
        btJoin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etName1.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(),"이름을 입력하세요.",Toast.LENGTH_SHORT).show();
                    etName1.requestFocus();
                    return;
                }
                if (etId1.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(),"아이디 입력하세요.",Toast.LENGTH_SHORT).show();
                    etId1.requestFocus();
                    return;
                }
                if (etPwd1.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(),"비밀번호를 입력하세요.",Toast.LENGTH_SHORT).show();
                    etPwd1.requestFocus();
                    return;
                }
                if (etPwdCheck1.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(),"비밀번호 확인을 입력하세요.",Toast.LENGTH_SHORT).show();
                    etPwdCheck1.requestFocus();
                    return;
                }
                if (etPhone1.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(),"전화번호를 입력하세요.",Toast.LENGTH_SHORT).show();
                    etPhone1.requestFocus();
                    return;
                }
                if (etEmail1.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(),"이메일을 입력하세요.",Toast.LENGTH_SHORT).show();
                    etEmail1.requestFocus();
                    return;
                }
                if (!etPwd1.getText().toString().equals(etPwdCheck1.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    etPwd1.setText("");
                    etPwdCheck1.setText("");
                    etPwd1.requestFocus();
                    return;
                }
                Insert insert = new Insert();
                insert.dataInsert();
            }
        });

        btCancel1 = findViewById(R.id.btCancel1);
        btCancel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
