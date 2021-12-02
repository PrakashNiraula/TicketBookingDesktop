package com.example.ticketer.view_controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ticketer.R;
import com.example.ticketer.module.User;
import com.example.ticketer.module.Vehicle;
import com.example.ticketer.module.decoder;
import com.example.ticketer.module.mapper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class BusDetails extends AppCompatActivity {

    Vehicle vehicle = new Vehicle();
    EditText busnumber, imagepath;
    Button addbus;
    Bundle bundle;
    ImageButton selectpicture;
    ImageView displayimage;
    private final int PICK_IMAGE_CAMERA = 1, PICK_IMAGE_GALLERY = 2;
    File destination;
    String imgPath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_details);
        busnumber = findViewById(R.id.vehiclenumber);
//        imagepath = findViewById(R.id.vehicleimage);
        addbus = findViewById(R.id.addbus);
        bundle = getIntent().getExtras();
        selectpicture = findViewById(R.id.addimage);
        displayimage=findViewById(R.id.selectedimage);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        selectpicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });


        addbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (busnumber.getText().toString().equals("")) {
                    rendermessage("Bus number cannot be empty");
                    return;
                }
                if (imagepath.getText().toString().equals(" ")) {
                    rendermessage("Image is necessary");
                    return;
                }
                vehicle.setVehicleType("Bus");
                vehicle.setVehicleNumber(busnumber.getText().toString());
//                vehicle.setImage(imagepath.getText().toString());
                String decoded = null;
                try {
                    decoded = decoder.decoded(bundle.get("token").toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Map<String, String> map = mapper.stringmapper(decoded);
                vehicle.setOwner(map.get("id"));
                String token = "Bearer ";
                token += bundle.get("token").toString();
                Vehicle newvehicle = vehicle.createVehicle(token, vehicle);
                User newuser = vehicle.pushVehicleToUser(token, map.get("id"), newvehicle);



                Intent intent = new Intent(BusDetails.this, ScheduleManager.class);
                intent.putExtra("token", bundle.get("token").toString());
                intent.putExtra("route_id", bundle.get("route").toString());
                intent.putExtra("vehicle_id", newvehicle.getId());
                startActivity(intent);
            }
        });

    }

    public void rendermessage(String message) {
        Toast.makeText(BusDetails.this, message, Toast.LENGTH_LONG).show();

    }

    private void selectImage() {
        final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo"))
                {
                    Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(takePicture, 0);
                }
                else if (options[item].equals("Choose from Gallery"))
                {
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto , 1);
                }
                else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case 0:
                Bitmap bitmap;
                if(resultCode==RESULT_OK){
                    try {

                        bitmap = (Bitmap) data.getExtras().get("data");
                        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bytes);
                        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
                        destination = new File(Environment.getExternalStorageDirectory() + "/" +
                                getString(R.string.app_name), "IMG_" + timeStamp + ".jpg");
                        FileOutputStream fo;
                        try {
                            destination.createNewFile();
                            fo = new FileOutputStream(destination);
                            fo.write(bytes.toByteArray());
                            fo.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }



                         imgPath = destination.getAbsolutePath();
                        displayimage.setImageBitmap(bitmap);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                break;
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = data.getData();
                    displayimage.setImageURI(selectedImage);
                }

                break;
        }
    }



}