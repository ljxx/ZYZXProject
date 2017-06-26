package com.ylx.zyzxproject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ylx.zyzxproject.R;
import com.ylx.zyzxproject.mainfragment.AffairFragment;
import com.ylx.zyzxproject.mainfragment.HomeFragment;
import com.ylx.zyzxproject.mainfragment.InformationFragment;
import com.ylx.zyzxproject.mainfragment.SafetyFragment;
import com.ylx.zyzxproject.mainfragment.UserFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderProtectFragment extends Fragment implements OnClickListener {
	private static final String TAG = "OrderAllFragment";
	private ArrayList<Fragment> list;
	private TextView barText;
	private int currIndex;
	private ViewPager viewpager_order;
	private View mView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_order_protect, null);
		mFragmentManager = getChildFragmentManager();
		/**
		 * 初始化数据
		 */
		initData(savedInstanceState);

		/**
		 * 初始化view
		 */
		initView();
		return mView;
	}

	private RadioGroup mRadioGroup;

	private boolean doubleClick = false;

	private List<String> mFragmentTags;
	private int mCurrentIndex;
	private final String CURRENTINDEX = "mCurrentIndex";
	private final int FRAGMENT_ZERO = 0;
	private final int FRAGMENT_FIRST = 1;
	private final int FRAGMENT_SECOND = 2;
	private final int FRAGMENT_THREE = 3;
	private final int FRAGMENT_FOUR = 4;

	private FragmentManager mFragmentManager;


	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(CURRENTINDEX,mCurrentIndex);
	}

	private void initData(Bundle savedInstanceState) {
		mFragmentTags = new ArrayList<String>(Arrays.asList("HomeFragment","AffairFragment","InformationFragment","SafetyFragment","UserFragment"));
		mCurrentIndex = FRAGMENT_ZERO; //默认首页0
		if(savedInstanceState != null){
			mCurrentIndex = savedInstanceState.getInt(CURRENTINDEX);
			hindSaveFragment();
		}
	}

	/**
	 * 隐藏保存Fragment
	 */
	private void hindSaveFragment() {
		Fragment mFragment = mFragmentManager.findFragmentByTag(mFragmentTags.get(mCurrentIndex));
		if(mFragment != null){
			mFragmentManager.beginTransaction().hide(mFragment).commit();
		}
	}

	/**
	 * 初始化view
	 */
	private void initView() {
		mRadioGroup = (RadioGroup) mView.findViewById(R.id.mRadioGroup);
		mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup radioGroup, int position) {
				switch (position){
					case R.id.mRBHome:
						mCurrentIndex = FRAGMENT_ZERO;
						break;
					case R.id.mRBMap:
						mCurrentIndex = FRAGMENT_FIRST;
						break;
					case R.id.mRBCenter:
						mCurrentIndex = FRAGMENT_SECOND;
						break;
					case R.id.mRBFind:
						mCurrentIndex = FRAGMENT_THREE;
						break;
					case R.id.mRBUser:
						mCurrentIndex = FRAGMENT_FOUR;
						break;
					default:break;
				}
				showFragment();
			}
		});
		showFragment();
	}

	/**
	 * 展示fragment
	 */
	private void showFragment() {
		Fragment fragment = mFragmentManager.findFragmentByTag(mFragmentTags.get(mCurrentIndex));
		if(fragment == null){
			fragment = initFragment(mCurrentIndex);
		}

		FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
		for(int i = 0 ;i < mFragmentTags.size(); i++){
			Fragment ft = mFragmentManager.findFragmentByTag(mFragmentTags.get(i));
			if(ft != null && ft.isAdded()){
				fragmentTransaction.hide(ft);
			}
		}

		if(fragment.isAdded()){
			fragmentTransaction.show(fragment);
		} else {
			fragmentTransaction.replace(R.id.mFrameLayout,fragment,mFragmentTags.get(mCurrentIndex));
		}
		fragmentTransaction.commitAllowingStateLoss();
		mFragmentManager.executePendingTransactions();
	}

	private Fragment initFragment(int current) {
		switch (current){
			case FRAGMENT_ZERO:
				return  new HomeFragment();
			case FRAGMENT_FIRST:
				return new AffairFragment();
			case FRAGMENT_SECOND:
				return new InformationFragment();
			case FRAGMENT_THREE:
				return new SafetyFragment();
			case FRAGMENT_FOUR:
				return new UserFragment();
			default:
				return null;
		}
	}

	@Override
	public void onClick(View v) {

	}

}
