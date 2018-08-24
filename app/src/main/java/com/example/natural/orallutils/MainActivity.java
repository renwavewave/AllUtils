package com.example.natural.orallutils;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.natural.orallutils.Text.TextSpanUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        SpannableStringBuilder spannableStringBuilder = TextSpanUtils.getBuilder(this, "aaaaaaaaaaa你好")
                .setForegroundColor(Color.parseColor("#507daf"))
                .setClickSpan(new URLSpan("http://www.baidu.com") {
                    @Override
                    public void onClick(View widget) {
                        Toast.makeText(MainActivity.this, "你敢点我", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void updateDrawState(TextPaint ds) {
                        super.updateDrawState(ds);
                        ds.setColor(Color.parseColor("#457AC8"));
                        ds.setUnderlineText(false);
                    }
                })
                .append("我是能容忍我是能容忍我是能容忍我是能容忍我是能容忍我是能容忍我是能容忍").setForegroundColor(Color.parseColor("#333333")).create();
        textView.setMovementMethod(new LinkMovementMethod());//点击效果没有的
        textView.setText(spannableStringBuilder);
    }
}
