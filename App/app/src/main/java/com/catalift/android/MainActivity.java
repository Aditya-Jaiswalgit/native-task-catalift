package com.catalift.android;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.catalift.android.Adapter.ExploreAdapter;
import com.catalift.android.Model.Explore;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.blue));
        }


        Button btnMyMentors = findViewById(R.id.mentor_button);
        Button btnExplore = findViewById(R.id.explore_button);

        btnMyMentors.setSelected(true);

        btnMyMentors.setOnClickListener(v -> {
            btnMyMentors.setSelected(true);
            btnExplore.setSelected(false);
        });

        btnExplore.setOnClickListener(v -> {
            btnExplore.setSelected(true);
            btnMyMentors.setSelected(false);
        });


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Explore> data = new ArrayList<>();
        data.add(new Explore(R.drawable.person, "4.9", "IT Sector", "Radhika Samant", "4 years", "Business Administration", "175 Reviews", "Strategy Manager @CEO Office |Ex-eBay...", "98% compatibility"));
        data.add(new Explore(R.drawable.person2, "4.7", "Marketing", "Arjun Mehra", "6 years", "Digital Marketing Lead", "120 Reviews", "Worked with Google Ads & Meta | SEO/SEM expert", "95% compatibility"));
        data.add(new Explore(R.drawable.person, "4.8", "Finance", "Neha Kapoor", "5 years", "Financial Analyst", "142 Reviews", "Ex-KPMG | Budgeting & Investment Strategy Mentor", "96% compatibility"));
        data.add(new Explore(R.drawable.person2, "4.6", "Product Design", "Ishaan Verma", "3 years", "UX/UI Designer", "110 Reviews", "Product Designer @Zomato | Specializes in mobile UX", "93% compatibility"));
        data.add(new Explore(R.drawable.person, "5.0", "Human Resources", "Meera Singh", "7 years", "HR Business Partner", "200 Reviews", "People strategist | Ex-Deloitte | Leadership Coach", "99% compatibility"));
        data.add(new Explore(R.drawable.person2, "4.5", "Software Engineering", "Kunal Desai", "8 years", "Senior Android Developer", "90 Reviews", "Android Expert | Kotlin, Jetpack | Ex-Samsung", "94% compatibility"));

        ExploreAdapter adapter = new ExploreAdapter(this, data);
        recyclerView.setAdapter(adapter);

        TextInputEditText searchBar = findViewById(R.id.search_bar);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });


    }
}