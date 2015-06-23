package com.asia.pcm2amr;


import com.asia.pcm2amr.TransferThread.TransferCallback;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();
    }
    
    private TextView hintView;
    private Button startButton;
	private void initView() {
		startButton = (Button) findViewById(R.id.btn_start);
		startButton.setOnClickListener(this);
		hintView = (TextView) findViewById(R.id.hint);
	}
	
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_start) {
			transferButtonClicked();
		}
	}
	
	private void transferButtonClicked(){
		showWaitDialog();
		startTransfer();
	}
	
	private ProgressDialog waitDialog;
	private void showWaitDialog(){
		waitDialog = new ProgressDialog(this);
		waitDialog.setTitle(getResources().getString(R.string.transfer_wait_title));
		waitDialog.setMessage(getResources().getString(R.string.transfer_wait_message));
		waitDialog.show();
	}
	
	private void startTransfer() {
		new TransferThread(this, new TransferCallback() {
			
			@Override
			public void onSuccess() {
				transferSuccess();
			}

			@Override
			public void onFailed() {
			}
		}).start();
	}
	
	private void transferSuccess() {
		runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				waitDialog.dismiss();
				hintView.setText(getResources().getString(R.string.transfer_result));
				ToastUtil.showShort(MainActivity.this, R.string.success_hint);
			}
		});
	}
}
