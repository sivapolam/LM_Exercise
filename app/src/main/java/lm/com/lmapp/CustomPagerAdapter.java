package lm.com.lmapp;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by skumar128 on 9/11/17.
 */

public class CustomPagerAdapter extends PagerAdapter implements Constants{

    private Context mContext;
    private String mCurr;
    String [] arrImage = new String[] {
            "http://be962883fa4932cb8c45-4918b6c23895973d0d77439479dabaa9.r81.cf3.rackcdn.com/119580217-PA008_01-800.jpg",
            "http://be962883fa4932cb8c45-4918b6c23895973d0d77439479dabaa9.r81.cf3.rackcdn.com/117514970-MOD9611_01-800.jpg",
            "http://7363c8e5d644af3f61fe-f801ca07733addcf236da446f6ef5b12.r6.cf3.rackcdn.com/BA68420_01-215.jpg"
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
        //image.setImageURI(Uri.parse("http://be962883fa4932cb8c45-4918b6c23895973d0d77439479dabaa9.r81.cf3.rackcdn.com/119580217-PA008_01-800.jpg"));
        Picasso.with(mContext).load(arrImage[position]).into(image);
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
