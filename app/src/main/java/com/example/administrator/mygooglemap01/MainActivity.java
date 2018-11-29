package com.example.administrator.mygooglemap01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.administrator.mygooglemap01.R.id.map;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(map);
        supportMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        /*앱의 초기화면 구성*/
        final LatLng location = new LatLng(40.771217, -73.971884);

        googleMap.addMarker(new MarkerOptions().position(location).title("맨해튼 Central-Park"));    //위치값
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 10));

        /*3D 효과전환버튼 클릭시 변경하는 구성 요소 */
        Button button = (Button) findViewById(R.id.btn_3d);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(location)   //맵의 중심(3d) - 주변광경을 볼 수 있음.
                        .zoom(16)   //줌인 줌아웃 효과
                        .bearing(90)    //카메라의 방향을 설정 각도
                        .tilt(30)   //카메라가 지평선으로부터 몇도 상위로 보이는지에 대한 각도입니다.
                        .build();

                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });

    }



}
