package com.example.a.instagramhome;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;

import adapter.PostAdapter;
import adapter.StoriesAdapter;
import model.PostModel;
import model.StoriesModel;

public class Home extends AppCompatActivity implements View.OnClickListener{
    private Integer[] PROFILE = {R.drawable.rdj,R.drawable.rocky,R.drawable.rock,R.drawable.will,R.drawable.hitler,R.drawable.mj,R.drawable.miketyson,R.drawable.jt,R.drawable.johnnydepp,R.drawable.jfk,R.drawable.barackobama};
    private String[] NAME = {"Sam","Rick","Richard","Tony","Bruce","Steve","Chandler","Star","Stark","Joey","Ross"};
    private String[] LIKE = {"1995","257","698","387","524","987","661","128","1025","582","448"};
    private String[] CAPTION = {"Movie #FAB","Gym is lyf......#gymfreak","Keep the smile everytime....<3","MAN IN BLACK...#MIB","Mr. Dictator","Music heals everything...","Ranfom clicks...#candid","I'm Lovin it...","Pirate is kind a my thing...#Pirateforlyf","Mr. President...#whitehouse","Every body's choice....#mr.fav"};
    private String[] CAPTIONNAME = {"Robbie","inch_01","half_penny","Pratt__","Mr.Perfect","James_Bond_007","Cent_50","nestify","Player_89","Osborne","Prolific"};

    private ArrayList<PostModel> postModelArrayList;
    private RecyclerView postrecy;
    private PostAdapter postAdapter;

    private ArrayList<StoriesModel> storiesModelArrayList;
    private RecyclerView recyclerView;
    private StoriesAdapter storiesAdapter;

    LinearLayout homelinear,searchlinear,instalinear,heartlinear,profilelinear;
    ImageView home,search,insta,heart,profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homelinear = findViewById(R.id.homelinear);
        searchlinear = findViewById(R.id.searchlinear);
        instalinear = findViewById(R.id.instalinear);
        heartlinear = findViewById(R.id.heartlinear);
        profilelinear = findViewById(R.id.profilelinear);

        home = findViewById(R.id.hometool);
        search = findViewById(R.id.searchtool);
        insta = findViewById(R.id.instatool);
        heart = findViewById(R.id.hearttool);
        profile = findViewById(R.id.profiletool);

        /////Code for Circular Stories
        recyclerView = findViewById(R.id.recystories);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Home.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        storiesModelArrayList = new ArrayList<>();

        for(int i=0;i<PROFILE.length;i++){
            StoriesModel storiesModel = new StoriesModel();
            storiesModel.setProfile(PROFILE[i]);
            storiesModel.setName(NAME[i]);

            storiesModelArrayList.add(storiesModel);
        }

        storiesAdapter = new StoriesAdapter(Home.this,storiesModelArrayList);
        recyclerView.setAdapter(storiesAdapter);


        /////Code for Posts
        postrecy = findViewById(R.id.recypost);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(Home.this);
        postrecy.setLayoutManager(layoutManager1);
        postrecy.setItemAnimator(new DefaultItemAnimator());
        postModelArrayList = new ArrayList<>();

        for (int i=0;i<PROFILE.length;i++){
            PostModel postModel = new PostModel();
            postModel.setProfile(PROFILE[i]);
            postModel.setPost(PROFILE[i]);
            postModel.setName(NAME[i]);
            postModel.setLike(LIKE[i]);
            postModel.setCaption(CAPTION[i]);
            postModel.setCaptionname(CAPTIONNAME[i]);

            postModelArrayList.add(postModel);
        }

        postAdapter = new PostAdapter(Home.this,postModelArrayList);
        postrecy.setAdapter(postAdapter);

        homelinear.setOnClickListener(this);
        searchlinear.setOnClickListener(this);
        instalinear.setOnClickListener(this);
        heartlinear.setOnClickListener(this);
        profilelinear.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.homelinear:

                home.setImageResource(R.drawable.ic_home_black);
                search.setImageResource(R.drawable.ic_search);
                insta.setImageResource(R.drawable.ic_icons8_instagram_96);
                heart.setImageResource(R.drawable.ic_heart_outline);
                profile.setImageResource(R.drawable.ic_perm_identity);

                break;

            case R.id.searchlinear:

                home.setImageResource(R.drawable.ic_home_outline);
                search.setImageResource(R.drawable.ic_search);
                insta.setImageResource(R.drawable.ic_icons8_instagram_96);
                heart.setImageResource(R.drawable.ic_heart_outline);
                profile.setImageResource(R.drawable.ic_perm_identity);

                break;

            case R.id.instalinear:

                home.setImageResource(R.drawable.ic_home_outline);
                search.setImageResource(R.drawable.ic_search);
                insta.setImageResource(R.drawable.ic_icons8_instagram_black_100);
                heart.setImageResource(R.drawable.ic_heart_outline);
                profile.setImageResource(R.drawable.ic_perm_identity);

                break;

            case R.id.heartlinear:

                home.setImageResource(R.drawable.ic_home_outline);
                search.setImageResource(R.drawable.ic_search);
                insta.setImageResource(R.drawable.ic_icons8_instagram_96);
                heart.setImageResource(R.drawable.ic_heart_black);
                profile.setImageResource(R.drawable.ic_perm_identity);

                break;

            case R.id.profilelinear:

                home.setImageResource(R.drawable.ic_home_outline);
                search.setImageResource(R.drawable.ic_search);
                insta.setImageResource(R.drawable.ic_icons8_instagram_96);
                heart.setImageResource(R.drawable.ic_heart_outline);
                profile.setImageResource(R.drawable.ic_person);

                break;


        }

    }
}
