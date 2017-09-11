package lm.com.lmapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by skumar128 on 9/11/17.
 */

public class CustomPagerAdapter extends PagerAdapter implements Constants{

    private Context mContext;
    private String mCurr;
    int [] arrImage = new int[] {
        R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher
    };
    String [] arrTitle = new String[]{
            "Title 1","Title 2","Title 3"
    };

    String [] arrPrice = new String[]{
            "10,000","9,000","8,000"
    };

    public CustomPagerAdapter(Context context, String curr) {
        mContext = context;
        mCurr = curr;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {

        String prefix = null;

        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.item, collection, false);
        ImageView image = (ImageView) layout.findViewById(R.id.image);
        TextView title = (TextView) layout.findViewById(R.id.title);
        TextView price = (TextView) layout.findViewById(R.id.price);
        image.setImageResource(arrImage[position]);

        switch (mCurr){
            case INR:
                prefix = "\u20B9";
                break;
            case SAR:
                prefix = "SAR";
                break;
            case AED:
                prefix = "AED";
                break;
        }

        title.setText(arrTitle[position]);
        price.setText(prefix+ " "+arrPrice[position]);
        collection.addView(layout);

        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return arrImage.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public float getPageWidth(int position) {
        return 0.5f;
    }
}
