/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ran.pics.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.ran.pics.R;
import com.ran.pics.activity.fragment.ImageGridFragment;
import com.ran.pics.application.UILApplication;
import com.ran.pics.util.ToastUtil;

public class ImageSearchResultActivity extends BaseActivity {
    public static final String KEY_WORD = "keyword";
    private ImageGridFragment imageGridFragment;
    private EditText etSearch;
    private String keyword;

    public static void startImageSearchResultActivity(Activity fromActivity, String keyword){
        Intent intent = new Intent(fromActivity,ImageSearchResultActivity.class);
        intent.putExtra(KEY_WORD,keyword);
        fromActivity.startActivity(intent);
    }
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_classifi);
        keyword = getIntent().getStringExtra(KEY_WORD);

        initView();
        initEvent();
	}

    private void initView(){
        etSearch = (EditText)findViewById(R.id.etSearch);
        etSearch.setText(keyword);
        imageGridFragment = ImageGridFragment.newInstance(keyword,false);
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragmentReplace,imageGridFragment).commit();
    }

    private void initEvent(){
        etSearch.setOnEditorActionListener(
                new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                            if (etSearch.getText().toString().trim().equals("")) {
                                ToastUtil.show(ImageSearchResultActivity.this, "请输入有效关键字");
                                return false;
                            }
                            UILApplication.missKeyBoard(ImageSearchResultActivity.this);
                            imageGridFragment.search(etSearch.getText().toString().trim());
                            return true;
                        }
                        return false;
                    }
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
