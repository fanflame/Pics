package com.ran.pics.adapter;//package com.ran.bitmapfun.adapter;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import android.content.Context;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;
//import android.support.v4.app.FragmentStatePagerAdapter;
//import android.view.ViewGroup;
//
//import com.ran.bitmapfun.activity.fragment.ImageGridFragment;
//import com.ran.bitmapfun.bean.Pic;
//
///**
// * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one
// * of the sections/tabs/pages.
// */
//public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
//	private int num = 2;
//	private ImageGridFragment currentFragment;
//	private HashMap<Integer, ImageGridFragment> fragmentMap;
//
//	private Context context;
//
//	public SectionsPagerAdapter(FragmentManager fm, Context context) {
//		super(fm);
//		this.context = context;
//	}
//
//	@Override
//	public Fragment getItem(int position) {
//		// getItem is called to instantiate the fragment for the given page.
//		if (fragmentMap == null) {
//			fragmentMap = new HashMap<Integer, ImageGridFragment>();
//		}
//		if ((currentFragment = fragmentMap.get(position)) == null) {
//			currentFragment = ImageGridFragment.newInstance(position);
//			fragmentMap.put(position, currentFragment);
//		}
//		return currentFragment;
//	}
//
//	@Override
//	public Object instantiateItem(ViewGroup container, int position) {
//		return super.instantiateItem(container, position);
//	}
//
//	@Override
//	public int getCount() {
//		return num;
//	}
//
//	public void setNum(int currentNum) {
//		if (currentNum + 1 == num)
//			num++;
//	}
//
//	@Override
//	public void notifyDataSetChanged() {
//		// if(currentFragment != null)
//		// currentFragment.notifyAdapter();
//		super.notifyDataSetChanged();
//	}
//
//	public void notifyCurrentFragmentDataSetChanged(int position) {
//		if (fragmentMap != null && fragmentMap.get(position - 1) != null) {
//			fragmentMap.get(position - 1).notifyAdapter();
//		}
//		this.notifyDataSetChanged();
//	}
//
//	public void clearCache() {
//		if(currentFragment != null)
////			currentFragment.clearCache();
//		num = 2;
//		this.notifyDataSetChanged();
//		if(fragmentMap != null)
//		    fragmentMap.clear();
//	}
//
//	public void setCurrentFragmentData(int position, ArrayList<Pic> picList) {
//		if (fragmentMap!= null && fragmentMap.get(position - 1) != null) {
//			fragmentMap.get(position - 1).setCurrentFragmentData(picList);
//		}
//	}
//
//	public void setCurrentFragment(int position) {
//		if(fragmentMap != null)
//		    currentFragment = fragmentMap.get(position);
//	}
//
//	@Override
//	public void destroyItem(ViewGroup container, int position, Object object) {
//		final ImageGridFragment fragment = (ImageGridFragment) object;
//		// As the item gets destroyed we try and cancel any existing work.
////		fragment.cancelWork();
//		super.destroyItem(container, position, object);
//	}
//
//}
