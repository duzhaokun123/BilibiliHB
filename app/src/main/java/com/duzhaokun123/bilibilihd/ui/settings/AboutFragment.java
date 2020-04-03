package com.duzhaokun123.bilibilihd.ui.settings;

import android.annotation.SuppressLint;
import android.content.Intent;

import com.duzhaokun123.bilibilihd.BuildConfig;
import com.duzhaokun123.bilibilihd.R;
import com.duzhaokun123.bilibilihd.databinding.FragmentAboutBinding;
import com.duzhaokun123.bilibilihd.pbilibiliapi.api.PBilibiliClient;
import com.duzhaokun123.bilibilihd.ui.widget.BaseFragment;
import com.duzhaokun123.bilibilihd.utils.CustomTabUtil;

import java.util.Objects;

public class AboutFragment extends BaseFragment<FragmentAboutBinding> {

    @Override
    protected int initConfig() {
        return 0;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_about;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initView() {
        baseBind.version.setText(getString(R.string.version) + " " + BuildConfig.VERSION_NAME + " (" + BuildConfig.VERSION_CODE + ")");
        baseBind.buildType.setText(getString(R.string.build_type) + " " + BuildConfig.BUILD_TYPE);
        baseBind.bilibiliApiClientVersion.setText(getString(R.string.bilibili_api_client_version) + " " + PBilibiliClient.Companion.getInstance().getBilibiliClient().getBillingClientProperties().getVersion());
        baseBind.rlLicense.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), LicenseActivity.class);
            startActivity(intent);
        });
        baseBind.rlProjectHome.setOnClickListener(v -> CustomTabUtil.openUrl(Objects.requireNonNull(getContext()), getString(R.string.project_home_url)));
    }

    @Override
    protected void initData() {

    }
}