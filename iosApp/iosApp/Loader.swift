//
//  Loader.swift
//  iosApp
//
//  Created by Marco Gomiero on 01/12/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI

struct Loader: UIViewRepresentable {
        
    func makeUIView(context: Context) -> UIActivityIndicatorView {
        return UIActivityIndicatorView()
    }
    
    func updateUIView(_ uiView: UIActivityIndicatorView,
                      context: Context) {
            uiView.startAnimating()
    }
}
