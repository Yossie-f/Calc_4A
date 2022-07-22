package com.example.calc_4a;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    TextView ans_text,digit_text,fdigit_text;
    EditText ed1,ed2;
    Button btn_plus,btn_minus,btn_multi,btn_divide,btn_cl_1,btn_cl_2,btn_allcl;
    StringBuilder digit = new StringBuilder("");
    StringBuilder fdigit = new StringBuilder("");
    String[] digAry = {"","1","十","百","千","1万","十万","百万"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.editText1);
        ed2 = findViewById(R.id.editText2);
        ans_text = findViewById(R.id.ansView);
        digit_text = findViewById(R.id.Text_digit);
        fdigit_text = findViewById(R.id.Text_Fdigit);

        btn_plus = findViewById(R.id.Button00);
        btn_minus = findViewById(R.id.Button01);
        btn_multi = findViewById(R.id.Button02);
        btn_divide = findViewById(R.id.Button03);
        btn_cl_1 = findViewById(R.id.Button04);
        btn_cl_1.setBackground(getResources().getDrawable(R.drawable.button_background, null));
        btn_cl_2 = findViewById(R.id.Button05);
        btn_cl_2.setBackground(getResources().getDrawable(R.drawable.button_background, null));
        btn_allcl = findViewById(R.id.Button06);
        btn_allcl.setBackground(getResources().getDrawable(R.drawable.button_background, null));



        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button)v;
                String Text1,Text2,AnsText;
                Double dNum1,dNum2;
                Double dAns=0.0;
                Text1 = ed1.getText().toString();
                Text2 = ed2.getText().toString();

                try {
                    dNum1 = Double.parseDouble(Text1);
                    dNum2 = Double.parseDouble(Text2);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "数字を入力してください。", Toast.LENGTH_SHORT).show();
                    return;
                }

                dAns = dNum1 + dNum2;

                AnsText = String.valueOf(dAns);
                ans_text.setText(AnsText);
                askDigit(AnsText);
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button)v;
                String Text1,Text2,AnsText;
                Double dNum1,dNum2;
                Double dAns=0.0;
                Text1 = ed1.getText().toString();
                Text2 = ed2.getText().toString();

                try {
                    dNum1 = Double.parseDouble(Text1);
                    dNum2 = Double.parseDouble(Text2);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "数字を入力してください。", Toast.LENGTH_SHORT).show();
                    return;
                }

                dAns = dNum1 - dNum2;

                AnsText = String.valueOf(dAns);
                ans_text.setText(AnsText);
                askDigit(AnsText);
            }
        });

        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button)v;
                String Text1,Text2,AnsText;
                Double dNum1,dNum2;
                Double dAns=0.0;
                Text1 = ed1.getText().toString();
                Text2 = ed2.getText().toString();

                try {
                    dNum1 = Double.parseDouble(Text1);
                    dNum2 = Double.parseDouble(Text2);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "数字を入力してください。", Toast.LENGTH_SHORT).show();
                    return;
                }

                dAns = dNum1 * dNum2;

                AnsText = String.valueOf(dAns);
                ans_text.setText(AnsText);
                askDigit(AnsText);
            }
        });

        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button)v;
                String Text1,Text2,AnsText;
                Double dNum1,dNum2;
                Double dAns=0.0;
                Text1 = ed1.getText().toString();
                Text2 = ed2.getText().toString();

                try {
                    dNum1 = Double.parseDouble(Text1);
                    dNum2 = Double.parseDouble(Text2);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "数字を入力してください。", Toast.LENGTH_SHORT).show();
                    return;
                }

                dAns = dNum1 / dNum2;

                AnsText = String.valueOf(dAns);
                ans_text.setText(AnsText);
                askDigit(AnsText);
            }
        });

        btn_cl_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText("");
            }
        });

        btn_cl_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed2.setText("");
            }
        });

        btn_allcl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText("");
                ed2.setText("");
                ans_text.setText("");
                Toast.makeText(MainActivity.this, "オールクリア!!", Toast.LENGTH_SHORT).show();
                askDigit("");
            }
        });
    }

    public void askDigit(String AnsText) {
        if (!(AnsText.equals("")) && AnsText.lastIndexOf("E")==-1) {
            digit.delete(0, digit.length()).append("整数部の最大桁はの位です");
            fdigit.delete(0, fdigit.length());
            String ans_str = AnsText;
            int dotIndex = ans_str.indexOf(".");

            String intPart_str;
            if(ans_str.indexOf("-")!=-1){
                intPart_str = ans_str.substring(1, dotIndex);
            }else{
                intPart_str = ans_str.substring(0, dotIndex);
            }

            int intPart = intPart_str.length();
            digit.insert(8, digAry[intPart]);
            digit_text.setText(digit.toString());

            int fractPart = ans_str.length() - 1 - dotIndex;
            fdigit.append("小数第" + fractPart + "位まで表示");
            fdigit_text.setText(fdigit.toString());

        } else if(AnsText.lastIndexOf("E")!=-1) {
            digit_text.setText("桁溢れです💦");
            fdigit_text.setText("");
            Toast.makeText(MainActivity.this, "有効桁数をオーバーしました💦", Toast.LENGTH_SHORT).show();
        } else {
            digit_text.setText(digit.delete(0, digit.length()).toString());
            fdigit_text.setText(fdigit.delete(0, fdigit.length()).toString());
        }
    }
}
