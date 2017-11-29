package com.info.wanggc.learnandroidui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

/**
 * Created by wanggc on 2017/11/25.
 */
public class GridLayoutActivity extends Activity {

    private GridLayout gridLayout;
    private TextView screenView;
    private Button clearBtn;

    private boolean hasClickOpter = false;
    private String operator;
    private double result;

    private final static String Operator_Mul = "+";
    private final static String Operator_Dcr = "-";
    private final static String Operator_Sup = "×";
    private final static String Operator_Did = "÷";
    private final static String Operator_Equ = "=";

    private String[] chars = new String[] {
            "7","8","9","÷",
            "4","5","6","×",
            "1","2","3","-",
            ".","0","=","+"
    };

    @Override
    public void onCreate(Bundle onsaveInstanceBundle) {
        super.onCreate(onsaveInstanceBundle);
        setContentView(R.layout.grid_layout_learn);

        initView();
    }

    public void initView(){
        gridLayout = findViewById(R.id.root);
        screenView = findViewById(R.id.screen);
        clearBtn = findViewById(R.id.clear);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screenView.setText("0");
                result = 0;
                operator = "";
                hasClickOpter = false;
            }
        });

        for (int i = 0;i<chars.length; i++) {
            Button button = new Button(this);
            button.setText(chars[i]);
            button.setTag(chars[i]);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    result = Double.valueOf(String.valueOf(screenView.getText()));
                    String tag = String .valueOf(view.getTag());
                    switch (tag) {
                        case GridLayoutActivity.Operator_Mul:
                        case GridLayoutActivity.Operator_Dcr:
                        case GridLayoutActivity.Operator_Sup:
                        case GridLayoutActivity.Operator_Did:
                            hasClickOpter = true;
                            operator = tag;
                            break;
                        case GridLayoutActivity.Operator_Equ:
                            hasClickOpter = false;
                            operator = "";
                            break;
                        default:
                            if(hasClickOpter) {
                                switch (operator) {
                                    case GridLayoutActivity.Operator_Mul:
                                        result = result + Integer.valueOf(String.valueOf(view.getTag()));
                                        break;
                                    case GridLayoutActivity.Operator_Dcr:
                                        result = result - Integer.valueOf(String.valueOf(view.getTag()));
                                        break;
                                    case GridLayoutActivity.Operator_Sup:
                                        result = result * Integer.valueOf(String.valueOf(view.getTag()));
                                        break;
                                    case GridLayoutActivity.Operator_Did:
                                        result = result / Integer.valueOf(String.valueOf(view.getTag()));
                                        break;
                                    case GridLayoutActivity.Operator_Equ:
                                        result = result / Integer.valueOf(String.valueOf(view.getTag()));
                                        break;
                                    default:
                                        break;
                                }
                                screenView.setText(String.valueOf(result));
                                hasClickOpter = false;
                                operator = "";
                            } else {
                                String screenResult = String.valueOf(screenView.getText());
                                if("0".equals(screenResult)) {
                                    screenView.setText(String.valueOf(view.getTag()));
                                } else {
                                    screenView.setText(screenResult + String.valueOf(view.getTag()));
                                }
                            }
                            break;
                    }
                }
            });

            button.setTextSize(40);
            button.setPadding(5,35,5,35);
            GridLayout.Spec spec = GridLayout.spec(i/4 + 2);
            GridLayout.Spec columnSpec = GridLayout.spec(i % 4);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams(spec,columnSpec);
            params.setGravity(Gravity.FILL);
            gridLayout.addView(button,params);
        }
    }


}
