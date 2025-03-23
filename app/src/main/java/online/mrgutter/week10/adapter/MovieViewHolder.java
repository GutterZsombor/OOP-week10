package online.mrgutter.week10.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



import online.mrgutter.week10.R;

//public class MovieViewHolder {
    /**
     * ViewHolder for category header items

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        private final TextView categoryNameTextView;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryNameTextView = itemView.findViewById(R.id.textViewCategoryName);
        }

        public void bind(String categoryName) {
            categoryNameTextView.setText(categoryName);
        }
    }
     */

    /**
     * ViewHolder for menu item entries
     */
    public  class MovieViewHolder extends RecyclerView.ViewHolder {
        private final ImageView itemImageView;
        private final TextView itemTitleTextView;
        private final TextView itemYearTextView;
        private final TextView itemGenreTextView;

        public MovieViewHolder( View itemView) {
            super(itemView);

            itemImageView = itemView.findViewById(R.id.imageViewPoster);
            itemTitleTextView = itemView.findViewById(R.id.textViewTitle);
            itemYearTextView = itemView.findViewById(R.id.textViewYear);
            itemGenreTextView = itemView.findViewById(R.id.textViewGener);


        }

        public ImageView getItemImageView() {
            return itemImageView;
        }

        public TextView getItemNameTextView() {
            return itemTitleTextView;
        }

        public TextView getItemPriceTextView() {
            return itemYearTextView;
        }

        public TextView getItemDescriptionTextView() {
            return itemGenreTextView;
        }
    }


