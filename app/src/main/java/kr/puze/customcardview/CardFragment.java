package kr.puze.customcardview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.Objects;

public class CardFragment extends Fragment {
    private CardView cardView;
    public static Fragment getInstance(String image, String title) {
        CardFragment f = new CardFragment();
        Bundle args = new Bundle();
        args.putString("image", image);
        args.putString("title", title);
        f.setArguments(args);
        return f;
    }
    @SuppressLint("DefaultLocale")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.card_view, container, false);
        cardView = view.findViewById(R.id.cardView);
        cardView.setMaxCardElevation(cardView.getCardElevation() * 8);
        TextView textView = view.findViewById(R.id.title);
        ImageView imageView = view.findViewById(R.id.img_background);
        assert getArguments() != null;
        String image = getArguments().getString("image");
        String title = getArguments().getString("title");
        Log.d("CardFragmentLog", image);
        Log.d("CardFragmentLog", title);
        textView.setText(title);
        Glide.with(Objects.requireNonNull(getActivity())).load(image).into(imageView);
        return view;
    }
    public CardView getCardView() {
        return cardView;
    }
}
