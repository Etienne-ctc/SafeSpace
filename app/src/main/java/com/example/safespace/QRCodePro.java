package com.example.safespace;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.WriterException;

import java.util.concurrent.ExecutionException;

public class QRCodePro extends AppCompatActivity {
    private ImageView qrCodeIV;
    private Button back;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code_pro);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        qrCodeIV = findViewById(R.id.idIVQrcode_ImageView);
        initQRCode(id);

        back = findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back_intent = new Intent(QRCodePro.this, HomePro.class);
                back_intent.putExtra("id", id);
                startActivity(back_intent);
            }
        });
    }

    private void initQRCode(String text){
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();

        // creating a variable for point which
        // is to be displayed in QR Code.
        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        int height = point.y;
        int dimen = Math.min(width, height);
        dimen = dimen * 3 / 4;

        // setting this dimensions inside our qr code
        // encoder to generate our qr code.

        qrgEncoder = new QRGEncoder(text, null, QRGContents.Type.TEXT, dimen);
        //bitmap = qrgEncoder.encodeAsBitmap();
        bitmap = qrgEncoder.getBitmap();
        qrCodeIV.setImageBitmap(bitmap);
    }
}