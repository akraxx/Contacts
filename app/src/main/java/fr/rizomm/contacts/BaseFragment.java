package fr.rizomm.contacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Maximilien on 22/02/2015.
 */
public abstract class BaseFragment extends Fragment implements InjectableResource {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Perform injection so that when this call returns all dependencies will be available for use.
        ((ContactApplication) getActivity().getApplication()).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(getContentView(), container, false);
        ButterKnife.inject(this, view);

        return onViewInflated(view, container, savedInstanceState);
    }

    public abstract View onViewInflated(View view,
                                        @Nullable ViewGroup container,
                                        @Nullable Bundle savedInstanceState);
}
