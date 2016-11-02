package ly.generalassemb.drewmahrt.shoppinglistdetailview.setup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import ly.generalassemb.drewmahrt.shoppinglistdetailview.R;
import ly.generalassemb.drewmahrt.shoppinglistdetailview.ShoppingItem;
import ly.generalassemb.drewmahrt.shoppinglistdetailview.ShoppingSQLiteOpenHelper;

/**
 * Created by justinwells on 11/2/16.
 */

public class DetailFragment extends Fragment {
    private int mSelectedItem;
    public static final String SELECTED_ITEM_ID = "ID";

    public DetailFragment() {
    }

    public static DetailFragment newInstance(int selectedItem) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt(SELECTED_ITEM_ID, selectedItem);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSelectedItem = getArguments().getInt(SELECTED_ITEM_ID);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

        TextView name = (TextView) view.findViewById(R.id.detail_name);
        TextView description = (TextView) view.findViewById(R.id.detail_description);
        TextView price = (TextView) view.findViewById(R.id.detail_price);
        TextView category = (TextView) view.findViewById(R.id.detail_category);

        // Get ID of selected item


        // Get the selected item from the database.
        // Write a new method in the open helper for this.
        ShoppingItem selectedItem = ShoppingSQLiteOpenHelper.getInstance(getContext())
                .getShoppingItemById(mSelectedItem);

        // If unable to retrieve item from database, no reason to continue


        // Populate the TextViews
        name.setText(selectedItem.getName());
        description.setText(selectedItem.getDescription());
        category.setText(selectedItem.getType());
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
        double priceValue = Double.valueOf(selectedItem.getPrice());
        price.setText(currencyFormat.format(priceValue));
    }
}
