package tk.taxhidinkadiri.finance;

import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;

    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;

    Button button1;
    Button button2;
    private String tag = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);

        TextView textView5 =(TextView) findViewById(R.id.textView5);

        textView1.setMovementMethod(new ScrollingMovementMethod());
        textView2.setMovementMethod(new ScrollingMovementMethod());
        textView3.setMovementMethod(new ScrollingMovementMethod());
        textView4.setMovementMethod(new ScrollingMovementMethod());
        textView5.setMovementMethod(new ScrollingMovementMethod());



        //
        editText1.setText("");
        editText2.setText("");
        editText3.setText("");
        editText4.setText("");
        editText5.setText("");
        editText6.setText("");

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        try {

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        boolean x = true;

                        while (x) {

                            String p = editText1.getText().toString();
                            String r = editText2.getText().toString();
                            String tv = editText3.getText().toString();
                            String tm = editText4.getText().toString();
                            String td = editText5.getText().toString();


                            Double pc = Double.valueOf(p);
                            Double rc = Double.valueOf(r);
                            Double tyearsc = Double.valueOf(tv);
                            Double tmonthc = Double.valueOf(tm);
                            Double tdays = Double.valueOf(td);


                            if (pc <= 0.0 && rc <= 0.0 && (tyearsc <= 0.0 || tmonthc <= 0.0 || tdays <= 0.0)) {
                                Toast.makeText(MainActivity.this, "Type input value", Toast.LENGTH_LONG).show();

                                x = false;

                                InputMethodManager mgr1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                mgr1.hideSoftInputFromWindow(button1.getWindowToken(), 0);
                                InputMethodManager mgr2 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                mgr2.hideSoftInputFromWindow(button2.getWindowToken(), 0);
                            } else if (pc > 0.0 && rc > 0.0 && (tyearsc > 0.0 || tmonthc > 0.0 || tdays > 0.0)) {
                                Double Icyears = (pc * rc * tyearsc) / 100;
                                Double Icmonths = (pc * rc * (tmonthc / 12)) / 100;
                                Double Icdays = (pc * rc * (tdays / 365.25)) / 100;

                                Double Ic = Icyears + Icmonths + Icdays;
                                String istring = Ic.toString();
                                editText6.setText(istring);
                                x = false;
                                InputMethodManager mgr1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                mgr1.hideSoftInputFromWindow(button1.getWindowToken(), 0);
                                InputMethodManager mgr2 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                mgr2.hideSoftInputFromWindow(button2.getWindowToken(), 0);
                            } else {
                                Toast.makeText(MainActivity.this, "Input value wrong", Toast.LENGTH_SHORT).show();
                                x = false;
                                InputMethodManager mgr1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                mgr1.hideSoftInputFromWindow(button1.getWindowToken(), 0);
                                InputMethodManager mgr2 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                mgr2.hideSoftInputFromWindow(button2.getWindowToken(), 0);
                            }


                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }


                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText5.setText("");
                    editText6.setText("");

                    InputMethodManager mgr1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    mgr1.hideSoftInputFromWindow(button1.getWindowToken(), 0);
                    InputMethodManager mgr2 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    mgr2.hideSoftInputFromWindow(button2.getWindowToken(), 0);
                }
            });


        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Interest = Principal × Rate × Time or I = P*R*T. "+ "Maturity value or Future value = Principal + Interest or MV=P + I", Snackbar.LENGTH_LONG)
                        .setAction("Interest = Principal × Rate × Time or I = PRT\n" + "Maturity value or Future value = Principal + Interest or MV=P + I", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}












//
//public class MainActivity extends AppCompatActivity  {
//
//    TextView textView1;
//    TextView textView2;
//    TextView textView3;
//    TextView textView4;
//
//    EditText editText1;
//    EditText editText2;
//    EditText editText3;
//    EditText editText4;
//    EditText editText5;
//    EditText editText6;
//
//    Button button1;
//    Button button2;
//    private String tag = "MainActivity";
//
//    private EditText result;
//    private EditText newNumber;
//    private TextView displayOperation;
//
//    // Variables to hold the operands and type of calculations
//    private Double operand1 = null;
//    private String pendingOperation = "=";
//
//    private static final String STATE_PENDING_OPERATION = "PendingOperation";
//    private static final String STATE_OPERAND1 = "Operand1";
//
//
//
//
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        final Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//
//        textView1 = (TextView) findViewById(R.id.textView1);
//        textView2 = (TextView) findViewById(R.id.textView2);
//        textView3 = (TextView) findViewById(R.id.textView3);
//        textView4 = (TextView) findViewById(R.id.textView4);
//
//        editText1 = (EditText) findViewById(R.id.editText1);
//        editText2 = (EditText) findViewById(R.id.editText2);
//        editText3 = (EditText) findViewById(R.id.editText3);
//        editText4 = (EditText) findViewById(R.id.editText4);
//        editText5 = (EditText) findViewById(R.id.editText5);
//        editText6 = (EditText) findViewById(R.id.editText6);
//
//        TextView textView5 =(TextView) findViewById(R.id.textView5);
//
//        textView1.setMovementMethod(new ScrollingMovementMethod());
//        textView2.setMovementMethod(new ScrollingMovementMethod());
//        textView3.setMovementMethod(new ScrollingMovementMethod());
//        textView4.setMovementMethod(new ScrollingMovementMethod());
//        textView5.setMovementMethod(new ScrollingMovementMethod());
//
//
//
//        //
//        editText1.setText("");
//        editText2.setText("");
//        editText3.setText("");
//        editText4.setText("");
//        editText5.setText("");
//        editText6.setText("");
//
//        button1 = (Button) findViewById(R.id.button1);
//        button2 = (Button) findViewById(R.id.button2);
//
//        try {
//
//            button1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    try {
//                        boolean x = true;
//
//                        while (x) {
//
//                            String p = editText1.getText().toString();
//                            String r = editText2.getText().toString();
//                            String tv = editText3.getText().toString();
//                            String tm = editText4.getText().toString();
//                            String td = editText5.getText().toString();
//
//
//                            Double pc = Double.valueOf(p);
//                            Double rc = Double.valueOf(r);
//                            Double tyearsc = Double.valueOf(tv);
//                            Double tmonthc = Double.valueOf(tm);
//                            Double tdays = Double.valueOf(td);
//
//
//                            if (pc <= 0.0 && rc <= 0.0 && (tyearsc <= 0.0 || tmonthc <= 0.0 || tdays <= 0.0)) {
//                                Toast.makeText(MainActivity.this, "Type input value", Toast.LENGTH_LONG).show();
//
//                                x = false;
//
//                                InputMethodManager mgr1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                                mgr1.hideSoftInputFromWindow(button1.getWindowToken(), 0);
//                                InputMethodManager mgr2 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                                mgr2.hideSoftInputFromWindow(button2.getWindowToken(), 0);
//                            } else if (pc > 0.0 && rc > 0.0 && (tyearsc > 0.0 || tmonthc > 0.0 || tdays > 0.0)) {
//                                Double Icyears = (pc * rc * tyearsc) / 100;
//                                Double Icmonths = (pc * rc * (tmonthc / 12)) / 100;
//                                Double Icdays = (pc * rc * (tdays / 365.25)) / 100;
//
//                                Double Ic = Icyears + Icmonths + Icdays;
//                                String istring = Ic.toString();
//                                editText6.setText(istring);
//                                x = false;
//                                InputMethodManager mgr1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                                mgr1.hideSoftInputFromWindow(button1.getWindowToken(), 0);
//                                InputMethodManager mgr2 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                                mgr2.hideSoftInputFromWindow(button2.getWindowToken(), 0);
//                            } else {
//                                Toast.makeText(MainActivity.this, "Input value wrong", Toast.LENGTH_SHORT).show();
//                                x = false;
//                                InputMethodManager mgr1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                                mgr1.hideSoftInputFromWindow(button1.getWindowToken(), 0);
//                                InputMethodManager mgr2 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                                mgr2.hideSoftInputFromWindow(button2.getWindowToken(), 0);
//                            }
//
//
//                        }
//                    } catch (NumberFormatException e) {
//                        e.printStackTrace();
//                    }
//
//
//                }
//            });
//
//            button2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    editText1.setText("");
//                    editText2.setText("");
//                    editText3.setText("");
//                    editText4.setText("");
//                    editText5.setText("");
//                    editText6.setText("");
//
//                    InputMethodManager mgr1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                    mgr1.hideSoftInputFromWindow(button1.getWindowToken(), 0);
//                    InputMethodManager mgr2 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                    mgr2.hideSoftInputFromWindow(button2.getWindowToken(), 0);
//                }
//            });
//
//
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }
//
//
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction(  "test",null).show();
//                Toast.makeText(MainActivity.this, "Calculator", Toast.LENGTH_LONG).show();
//
//
//            }
//        });
//
//
//
//        result = (EditText) findViewById(R.id.result);
//        newNumber = (EditText) findViewById(R.id.newNumber);
//        displayOperation = (TextView) findViewById(R.id.operation);
//
//         Button button0 = (Button) findViewById(R.id.button0);
//        Button button10 = (Button) findViewById(R.id.button1);
//        Button button20 = (Button) findViewById(R.id.button2);
//        Button button3 = (Button) findViewById(R.id.button3);
//        Button button4 = (Button) findViewById(R.id.button4);
//        Button button5 = (Button) findViewById(R.id.button5);
//        Button button6 = (Button) findViewById(R.id.button6);
//        Button button7 = (Button) findViewById(R.id.button7);
//        Button button8 = (Button) findViewById(R.id.button8);
//        Button button9 = (Button) findViewById(R.id.button9);
//        Button buttonDot = (Button) findViewById(R.id.buttonDot);
//
//        Button buttonEquals = (Button) findViewById(R.id.buttonEquals);
//        Button buttonDivide = (Button) findViewById(R.id.buttonDivide);
//        Button buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
//        Button buttonMinus = (Button) findViewById(R.id.ButtonMinus);
//        Button buttonPlus = (Button) findViewById(R.id.buttonPlus);
//
//
//        View.OnClickListener listener = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Button b = (Button) view;
//                newNumber.append(b.getText().toString());
//            }
//        };
//        button0.setOnClickListener(listener);
//        button10.setOnClickListener(listener);
//        button20.setOnClickListener(listener);
//        button3.setOnClickListener(listener);
//        button4.setOnClickListener(listener);
//        button5.setOnClickListener(listener);
//        button6.setOnClickListener(listener);
//        button7.setOnClickListener(listener);
//        button8.setOnClickListener(listener);
//        button9.setOnClickListener(listener);
//        buttonDot.setOnClickListener(listener);
//
//
//
//
//        View.OnClickListener opListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Button b = (Button) view;
//                String op = b.getText().toString();//operacionet  matematikore +,-
//                String value = newNumber.getText().toString();
//                try {
//
//                    Double doubleValue = Double.valueOf(value);
//                    performOperation(doubleValue, op);
//                } catch (NumberFormatException e) {
//                    newNumber.setText("");
//                }
//                pendingOperation = op;
//                displayOperation.setText(pendingOperation);
//            }
//        };
//
//        buttonEquals.setOnClickListener(opListener);
//        buttonDivide.setOnClickListener(opListener);
//        buttonMultiply.setOnClickListener(opListener);
//        buttonMinus.setOnClickListener(opListener);
//        buttonPlus.setOnClickListener(opListener);
//
//        Button buttonNeg = (Button) findViewById(R.id.buttonNeg);
//
//        buttonNeg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String value = newNumber.getText().toString();
//
//                if (value.length() == 0) {
//                    newNumber.setText("-");
//                } else {
//                    try {
//                        Double doubleValue = Double.valueOf(value);
//                        doubleValue *= -1;
//                        newNumber.setText(doubleValue.toString());
//                    } catch (NumberFormatException e) {
//                        // newNumber was "-" or ".", so clear it
//                        newNumber.setText("");
//                    }
//                }
//
//            }
//        });
//
//
//        Button buttonClear= (Button) findViewById(R.id.clear);
//        buttonClear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String valuetest =result.getText().toString();
//                Double convervalue=Double.valueOf(valuetest);
//                convervalue =0.0;
//                String stringconvertDouble=convervalue.toString();
//                result.setText(stringconvertDouble);
//                operand1=0.0;
//                result.setText(operand1.toString());
//            }
//        });
//
//
//
//    }
//
//    private void performOperation(Double value, String operation) {
//
//        if (null == operand1) {
//            operand1 = value;
//        }
//
//        else {
//            if (pendingOperation.equals("=")) {
//                pendingOperation = operation;
//            }
//            switch (pendingOperation) {
//                case "=":
//                    operand1 = value;
//                    break;
//                case "/":
//                    if (value == 0) {
//                        operand1 = 0.0;
//                    } else {
//                        operand1 /= value;
//                    }
//                    break;
//                case "*":
//                    operand1 *= value;
//                    break;
//                case "-":
//                    operand1 -= value;
//                    break;
//                case "+":
//                    operand1 += value;
//                    break;
//            }
//        }
//
//        result.setText(operand1.toString());
//        newNumber.setText("");
//    }
//
//
//
//
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        super.onOptionsItemSelected(item);
//
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        switch (item.getItemId()){
//            case R.layout.activity_calculator_2:
//                setContentView(R.layout.activity_calculator_2);
//                return  true;
//        }
//
//return false;
//        //     super.onOptionsItemSelected(item);
//        //
//        //        switch (item.getItemId()) {
//        //            case R.id.english:
//        //                setLanguage("English");
//        //                return true;
//        //            case R.id.spanish:
//        //                setLanguage("Spanish");
//        //                return true;
//        //            default:
//        //                return false;
//        //        }
//
//
//
//
//
//
//
//
//    }
//
//
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        outState.putString(STATE_PENDING_OPERATION, pendingOperation);
//        if (operand1 != null) {
//            outState.putDouble(STATE_OPERAND1, operand1);
//        }
//        super.onSaveInstanceState(outState);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        pendingOperation = savedInstanceState.getString(STATE_PENDING_OPERATION);
//        operand1 = savedInstanceState.getDouble(STATE_OPERAND1);
//        displayOperation.setText(pendingOperation);
//    }
//
//

//}
