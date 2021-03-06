package com.coffee.android_20170316;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ch10_page31_f extends AppCompatActivity {

  EditText edtNum1, edtNum2;
  Button btnAdd, btnMulti;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch10_page31_f);
    setTitle("Ch10_page31_f");

    edtNum1 = (EditText) findViewById(R.id.edtNum1);
    edtNum2 = (EditText) findViewById(R.id.edtNum2);
    btnAdd = (Button) findViewById(R.id.btnAdd);
    btnMulti = (Button) findViewById(R.id.btnMulti);

    // 더하기
    btnAdd.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // intent 객체를 새로 만들면서 현재 주소, 갈 주소 넣기
        Intent intent = new Intent(getApplicationContext(), Ch10_page31_s.class);

        // 사용자가 입력한 값 뽑아서 형 변환 시키기
        String stringInputNum1 = edtNum1.getText().toString();
        String stringInputNum2 = edtNum2.getText().toString();
        int intInputNum1 = Integer.parseInt(stringInputNum1);
        int intInputNum2 = Integer.parseInt(stringInputNum2);

        // intent 객체에 데이터 집어 넣기
        // intent.putExtra(K,V);
        // intent.putExtra(꺼낼때 사용할 이름, 보낼데이터값);
        intent.putExtra("num1", intInputNum1);
        intent.putExtra("num2", intInputNum2);

        // 페이지 전환
        // startActivity(intent);
        // 데이터를 다시 돌려받는 페이지 전환
        // startActivityForResult(intent,requestCode);
        startActivityForResult(intent, 0);
      }
    });
    // 곱하기
    btnMulti.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), Ch10_page31_t.class);

        String stringInputNum1 = edtNum1.getText().toString();
        String stringInputNum2 = edtNum2.getText().toString();
        int intInputNum1 = Integer.parseInt(stringInputNum1);
        int intInputNum2 = Integer.parseInt(stringInputNum2);

        intent.putExtra("num1", intInputNum1);
        intent.putExtra("num2", intInputNum2);

        startActivityForResult(intent, 1);
      }
    });
  }

  // 다른 페이지에서 리턴해준 intent 값 처리
  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {

    Toast.makeText(getApplicationContext(), "requestCode : " + requestCode, Toast.LENGTH_SHORT).show();

    // 성공 여부 확인하기 -> _s페이지에서 보낸 인증 코드 RESULT_OK 이 쓰이는 곳
    if (resultCode == RESULT_OK) {

      // 호출 할때 쓰인 requestCode로 분리 한다.
      if(requestCode==0) {
        int result = data.getIntExtra("result", 0);
        Toast.makeText(getApplicationContext(), "돌아온 result : " + result, Toast.LENGTH_SHORT).show();
      }if(requestCode==1){
        int result = data.getIntExtra("multiResult", 0);
        Toast.makeText(getApplicationContext(), "돌아온 result : " + result, Toast.LENGTH_SHORT).show();
      }
    }

  }
}
