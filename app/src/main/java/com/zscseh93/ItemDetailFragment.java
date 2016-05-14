package com.zscseh93;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zscseh93.data.Item;

public class ItemDetailFragment extends Fragment {

    public static final String ARG_ITEM = "item";

    private Item mItem;

    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM)) {
            mItem = getArguments().getParcelable(ARG_ITEM);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity
                    .findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

//        if (mItem != null) {
        if (mItem.getPlaceName() != null) {
            TextView tvPlaceName = (TextView) rootView.findViewById(R.id.tvPlaceName);
            tvPlaceName.setText(mItem.getPlaceName());
        }

        if (mItem.getPlaceAddress() != null) {
            TextView tvPlaceAddress = (TextView) rootView.findViewById(R.id.tvPlaceAddress);
            tvPlaceAddress.setText(mItem.getPlaceAddress());
        }

//        }

        return rootView;
    }
}
