package com.example.a1a1a1214.makingcustomviewsample;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by a1a1a1214 on 2018-04-20.
 */

public class MyCustomView extends LinearLayout
{
    private ImageView mStar1;
    private ImageView mStar2;
    private ImageView mStar3;
    //선택된 번호
    private int mSelected = 0;

    public MyCustomView(Context context)
    {
        super(context);
        initializeViews(context, null);
    }

    public MyCustomView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initializeViews(context, attrs);
    }

    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs);
        initializeViews(context, attrs);
    }

    private void initializeViews(Context context, AttributeSet attrs)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //레이아웃 전개
        inflater.inflate(R.layout.three_stars_indicator, this); //여기서 this는 LinearLayout 자기 자신이다.
        if (attrs != null)
        {
            //attrs.xml에 정의한 스타일을 가져옴.
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyCustomView);
            mSelected = a.getInteger(0, 0);
            //사용이 끝나면 recycle()을 호출.
            a.recycle();
        }
    }

    /*
    inflate가 완료되는 시점에 콜백!
     */

    @Override
    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mStar1 = (ImageView) findViewById(R.id.star1);
        mStar2 = (ImageView) findViewById(R.id.star2);
        mStar3 = (ImageView) findViewById(R.id.star3);

        //처음에만 XML의 지정을? 반영하고자 2번째 인수인 force를 true로 지정
        setSelected(mSelected, true);
    }


    /*
        지정된 번호 선택 (내부용)
        @parm select 지정한 번호 (0이 가장 왼쪽)
     */

    public void setSelected(int select)
    {
        setSelected(select, false);
    }


    /*
        지정된 번호로 선택 (내부용)
        @parm select : 지정할 번호 (0이 가장 왼쪽)
        @parm force :  지정을 강제로 반영
     */
    private void setSelected(int select, boolean force)
    {
        //지정이 변경되거나 선택된 번호가 같지 않은 경우
           if(force || mSelected != select)
           {
               //mSelected : 선택된 번호가 0~ 2사이일 경우
               if(2 > mSelected && mSelected < 0 )
               {
                   return ;
               }

               mSelected = select;

               if(mSelected == 0)
               {
                   mStar1.setImageResource(R.drawable.star);
                   mStar2.setImageResource(R.drawable.star_empty);
                   mStar3.setImageResource(R.drawable.star_empty);
               }

               else if(mSelected == 1)
               {
                   mStar1.setImageResource(R.drawable.star_empty);
                   mStar2.setImageResource(R.drawable.star);
                   mStar3.setImageResource(R.drawable.star_empty);
               }

               else if(mSelected == 2)
               {
                   mStar1.setImageResource(R.drawable.star_empty);
                   mStar2.setImageResource(R.drawable.star_empty);
                   mStar3.setImageResource(R.drawable.star);
               }
           }
    }

    public int getSelected ()
    {
        return mSelected;
    }
}
