//
//  MainScreen.swift
//  iosApp
//
//  Created by Marco Gomiero on 01/12/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MainScreen: View {
    
    @ObservedObject var viewModel = MainViewModel()
    
    var body: some View {
        NavigationView {
            if viewModel.showLoading {
                Loader()
            } else {
                VStack {
                    Text(viewModel.activityName)
                    Button("Get New Activity", action: {
                        viewModel.getActivity()
                    })
                }
                .navigationBarTitle(Text("Shared Deserialization"))
            }
        }
    }
}

