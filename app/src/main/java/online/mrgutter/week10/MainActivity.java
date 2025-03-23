package online.mrgutter.week10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import online.mrgutter.week10.adapter.MovieAdapter;
import online.mrgutter.week10.util.ErrorHandler;
import online.mrgutter.week10.util.JSONUtility;
import online.mrgutter.week10.util.MovieData;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    // UI components
    private TextView TitleTextView;

    private RecyclerView movieRecyclerView;

    // Data
    private MovieData movieData;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        initializeViews();

        // Load and display menu data
        loadMenuData();
    }

    /**
     * Initialize UI components
     */
    private void initializeViews() {
        TitleTextView = findViewById(R.id.textViewTitle);

        movieRecyclerView = findViewById(R.id.recyclerViewMovie);

        // Set up RecyclerView
        movieRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieRecyclerView.setHasFixedSize(true);
    }

    /**
     * Load menu data from JSON file
     */
    private void loadMenuData() {
        try {
            // Load menu data from JSON file
            movieData = JSONUtility.loadMovieData(this, R.raw.movies);


            // Create and set adapter
            movieAdapter = new MovieAdapter(


                    movieData.getMovies()

            );
            movieRecyclerView.setAdapter(movieAdapter);

        } catch (Exception e) {
            Log.e(TAG, "Error loading menu data", e);
            ErrorHandler.handleError(
                    this,
                    e,
                    "Failed to load menu data. Please try again later."
            );
        }
    }

    /**
     * Handle menu item click

    @Override
    public void onItemClick(int position) {
        try {
            MenuItem menuItem = menuAdapter.getMenuItem(position);
            if (menuItem != null) {
                // Launch detail activity
                Intent intent = new Intent(this, MenuDetailActivity.class);
                intent.putExtra(MenuDetailActivity.EXTRA_MENU_ITEM, menuItem);

                // Find category name for this item
                for (int i = 0; i < menuData.getCategories().size(); i++) {
                    if (menuData.getCategories().get(i).getId() == menuItem.getCategoryId()) {
                        intent.putExtra(MenuDetailActivity.EXTRA_CATEGORY_NAME,
                                menuData.getCategories().get(i).getName());
                        break;
                    }
                }

                startActivity(intent);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error handling item click", e);
            ErrorHandler.handleError(
                    this,
                    e,
                    "Failed to open item details. Please try again."
            );
        }
    } */
}