package com.e.arapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArFragment mArFragment;
    private ModelRenderable bearRenderable,
            catRenderable,
            cowRenderable,
            dogRenderable,
            elephantRenderable,
            ferretRenderable,
            hippopotamusRenderable,
            horseRenderable,
            koalaRenderable,
            lionRenderable,
            reindeerRenderable,
            wolverineRenderable;
    private ImageView bear, cat, cow, dog, elephant, ferret, hippopotamus, horse, koala, lion, reindeer, wolverine;
    View arrayView[];
    int select = 1; // Default Bear is choose


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mArFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);

        bear = (ImageView) findViewById(R.id.bear);
        cat = (ImageView) findViewById(R.id.cat);
        cow = (ImageView) findViewById(R.id.cow);
        dog = (ImageView) findViewById(R.id.dog);
        elephant = (ImageView) findViewById(R.id.elephant);
        ferret = (ImageView) findViewById(R.id.ferret);
        hippopotamus = (ImageView) findViewById(R.id.hippopotamus);
        horse = (ImageView) findViewById(R.id.horse);
        koala = (ImageView) findViewById(R.id.koalabear);
        lion = (ImageView) findViewById(R.id.lion);
        reindeer = (ImageView) findViewById(R.id.reindeer);
        wolverine = (ImageView) findViewById(R.id.wolverine);

        setArrayView();
        setClickListener();
        setupModel();

        mArFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {

            if (select == 1) {
                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(mArFragment.getArSceneView().getScene());
                createModel(anchorNode, select);
            }

        });
    }

    private void setupModel() {

        ModelRenderable.builder()
                .setSource(this, R.raw.bear)
                .build().thenAccept(renderable -> bearRenderable = renderable)
                .exceptionally(throwable ->
                {
                    Toast.makeText(this, "Unable to load Bear Model", Toast.LENGTH_SHORT).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this, R.raw.cat)
                .build().thenAccept(renderable -> catRenderable = renderable)
                .exceptionally(throwable ->
                {
                    Toast toast =
                        Toast.makeText(this, "Unable to load Cat Model", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this, R.raw.cow)
                .build().thenAccept(renderable -> cowRenderable = renderable)
                .exceptionally(throwable ->
                {
                    Toast toast =
                            Toast.makeText(this, "Unable to load cow Model", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, R.raw.dog)
                .build().thenAccept(renderable -> dogRenderable = renderable)
                .exceptionally(throwable ->
                {
                    Toast toast =
                            Toast.makeText(this, "Unable to load dog Model", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this, R.raw.elephant)
                .build().thenAccept(renderable -> elephantRenderable = renderable)
                .exceptionally(throwable ->
                {
                    Toast toast =
                            Toast.makeText(this, "Unable to load elephant Model", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this, R.raw.ferret)
                .build().thenAccept(renderable -> ferretRenderable = renderable)
                .exceptionally(throwable ->
                {
                    Toast toast =
                            Toast.makeText(this, "Unable to load ferret Model", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this, R.raw.hippopotamus)
                .build().thenAccept(renderable -> hippopotamusRenderable = renderable)
                .exceptionally(throwable ->
                {
                    Toast toast =
                            Toast.makeText(this, "Unable to load hippopotamus Model", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this, R.raw.horse)
                .build().thenAccept(renderable -> horseRenderable = renderable)
                .exceptionally(throwable ->
                {
                    Toast toast =
                            Toast.makeText(this, "Unable to load horse Model", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this, R.raw.koala_bear)
                .build().thenAccept(renderable -> koalaRenderable = renderable)
                .exceptionally(throwable ->
                {
                    Toast toast =
                            Toast.makeText(this, "Unable to load koala_bear Model", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this, R.raw.lion)
                .build().thenAccept(renderable -> lionRenderable = renderable)
                .exceptionally(throwable ->
                {
                    Toast toast =
                            Toast.makeText(this, "Unable to load lion Model", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this, R.raw.reindeer)
                .build().thenAccept(renderable -> reindeerRenderable = renderable)
                .exceptionally(throwable ->
                {
                    Toast toast =
                            Toast.makeText(this, "Unable to load reindeer Model", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this, R.raw.wolverine)
                .build().thenAccept(renderable -> wolverineRenderable = renderable)
                .exceptionally(throwable ->
                {
                    Toast toast =
                            Toast.makeText(this, "Unable to load wolverine Model", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return null;
                });
    }

    private void createModel(AnchorNode anchorNode, int select) {
        if (select == 1) {
            TransformableNode bear = new TransformableNode(mArFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(bearRenderable);
            bear.select();

            addName(anchorNode, bear, "Bear");
        }
        if (select == 2) {
            TransformableNode cat = new TransformableNode(mArFragment.getTransformationSystem());
            cat.setParent(anchorNode);
            cat.setRenderable(catRenderable);
            cat.select();

            addName(anchorNode, cat, "Cat");
        }
        if (select == 3) {
            TransformableNode cow = new TransformableNode(mArFragment.getTransformationSystem());
            cow.setParent(anchorNode);
            cow.setRenderable(cowRenderable);
            cow.select();

            addName(anchorNode, cow, "Cow");
        }
        if (select == 4) {
            TransformableNode dog = new TransformableNode(mArFragment.getTransformationSystem());
            dog.setParent(anchorNode);
            dog.setRenderable(dogRenderable);
            dog.select();

            addName(anchorNode, dog, "Dog");
        }
        if (select == 5) {
            TransformableNode elephant = new TransformableNode(mArFragment.getTransformationSystem());
            elephant.setParent(anchorNode);
            elephant.setRenderable(elephantRenderable);
            elephant.select();

            addName(anchorNode, elephant, "Elephant");
        }
        if (select == 6) {
            TransformableNode ferret = new TransformableNode(mArFragment.getTransformationSystem());
            ferret.setParent(anchorNode);
            ferret.setRenderable(ferretRenderable);
            ferret.select();

            addName(anchorNode, ferret, "Ferret");
        }
        if (select == 7) {
            TransformableNode hippopotamus = new TransformableNode(mArFragment.getTransformationSystem());
            hippopotamus.setParent(anchorNode);
            hippopotamus.setRenderable(hippopotamusRenderable);
            hippopotamus.select();

            addName(anchorNode, hippopotamus, "Hippopotamus");
        }
        if (select == 8) {
            TransformableNode horse = new TransformableNode(mArFragment.getTransformationSystem());
            horse.setParent(anchorNode);
            horse.setRenderable(horseRenderable);
            horse.select();

            addName(anchorNode, horse, "Horse");
        }
        if (select == 9) {
            TransformableNode koala = new TransformableNode(mArFragment.getTransformationSystem());
            koala.setParent(anchorNode);
            koala.setRenderable(koalaRenderable);
            koala.select();

            addName(anchorNode, koala, "Koala");
        }
        if (select == 10) {
            TransformableNode lion = new TransformableNode(mArFragment.getTransformationSystem());
            lion.setParent(anchorNode);
            lion.setRenderable(lionRenderable);
            lion.select();

            addName(anchorNode, lion, "Lion");
        }
        if (select == 11) {
            TransformableNode reindeer = new TransformableNode(mArFragment.getTransformationSystem());
            reindeer.setParent(anchorNode);
            reindeer.setRenderable(reindeerRenderable);
            reindeer.select();

            addName(anchorNode, reindeer, "Reindeer");
        }
        if (select == 12) {
            TransformableNode wolverine = new TransformableNode(mArFragment.getTransformationSystem());
            wolverine.setParent(anchorNode);
            wolverine.setRenderable(wolverineRenderable);
            wolverine.select();

            addName(anchorNode, wolverine, "Wolverine");
        }
    }

    private void addName(AnchorNode anchorNode, TransformableNode model, String name) {

        ViewRenderable.builder().setView(this, R.layout.name_animal)
                .build()
                .thenAccept(viewRenderable -> {

                    TransformableNode nameView = new TransformableNode(mArFragment.getTransformationSystem());
                    nameView.setLocalPosition(new Vector3(0f, model.getLocalPosition().y + 0.5f, 0 ));
                    nameView.setParent(anchorNode);
                    nameView.setRenderable(viewRenderable);
                    nameView.select();
                    TextView text_name = (TextView) viewRenderable.getView();
                    text_name.setText(name);

                    // Click to TextView to remove animal
                    text_name.setOnClickListener(view -> {
                        anchorNode.setParent(null);
                    });

                });

    }

    private void setClickListener() {
        for (int i = 0; i < arrayView.length; i++) {
            arrayView[i].setOnClickListener(this);

        }
    }


    private void setArrayView() {

        arrayView = new View[]{
                bear, cat, cow, dog, elephant, ferret, hippopotamus, horse, koala, lion, reindeer, wolverine
        };

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.bear) {
            select = 1;
            setBackground(view.getId());
        } else if (view.getId() == R.id.cat) {
            select = 2;
            setBackground(view.getId());
        }else if (view.getId() == R.id.cow) {
            select = 3;
            setBackground(view.getId());
        }else if (view.getId() == R.id.dog) {
            select = 4;
            setBackground(view.getId());
        }else if (view.getId() == R.id.elephant) {
            select = 5;
            setBackground(view.getId());
        }else if (view.getId() == R.id.ferret) {
            select = 6;
            setBackground(view.getId());
        }else if (view.getId() == R.id.hippopotamus) {
            select = 7;
            setBackground(view.getId());
        }else if (view.getId() == R.id.horse) {
            select = 8;
            setBackground(view.getId());
        }else if (view.getId() == R.id.koalabear) {
            select = 9;
            setBackground(view.getId());
        }else if (view.getId() == R.id.lion) {
            select = 10;
            setBackground(view.getId());
        }else if (view.getId() == R.id.reindeer) {
            select = 11;
            setBackground(view.getId());
        }else if (view.getId() == R.id.wolverine) {
            select = 12;
            setBackground(view.getId());
        }
    }

    private void setBackground(int id) {
        for (int i = 0; i < arrayView.length; i++) {
            if (arrayView[i].getId() == id) {
                arrayView[i].setBackgroundColor(Color.parseColor("#80333639"));
            } else {
                arrayView[i].setBackgroundColor(Color.TRANSPARENT);
            }
        }
    }
}
