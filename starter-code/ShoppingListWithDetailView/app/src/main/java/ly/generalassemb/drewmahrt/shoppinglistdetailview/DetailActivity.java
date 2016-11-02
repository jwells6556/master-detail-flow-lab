package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import ly.generalassemb.drewmahrt.shoppinglistdetailview.setup.DetailFragment;

public class DetailActivity extends AppCompatActivity {

    public static final String ITEM_ID_KEY = "itemIdKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        // Get ID of selected item
        int selectedItemId = getIntent().getIntExtra(ITEM_ID_KEY, -1);

        // If we don't have a valid ID, no reason to continue
        if (selectedItemId == -1) {
            Log.d("DetailActivity", "onCreate: No ID passed on the intent!");
            finish();
        }

        // Get the selected item from the database.
        // Write a new method in the open helper for this.
        ShoppingItem selectedItem = ShoppingSQLiteOpenHelper.getInstance(this)
                .getShoppingItemById(selectedItemId);

        // If unable to retrieve item from database, no reason to continue
        if (selectedItem == null) {
            Log.d("DetailActivity", "onCreate: Unable to get item from database!");
            finish();
        }

        DetailFragment detailFragment = DetailFragment.newInstance(selectedItemId);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.detail_fragment_container,detailFragment)
                .commit();
    }
}
