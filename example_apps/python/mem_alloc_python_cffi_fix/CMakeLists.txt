# stop configuration if cmake version is below 2.8
cmake_minimum_required(VERSION 2.8 FATAL_ERROR)

# project name and enabled languages
project(example CXX)

# workaround for CMP0042 warning on Mac
if(${CMAKE_SYSTEM_NAME} MATCHES "Darwin")
    if(NOT DEFINED CMAKE_MACOSX_RPATH)
        set(CMAKE_MACOSX_RPATH ON)
    endif()
endif()

# set default build paths
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${PROJECT_BINARY_DIR}/bin)
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${PROJECT_BINARY_DIR}/lib)

# generated export header will be placed here
include_directories(${PROJECT_BINARY_DIR})

# define library
add_library(
    example
    SHARED
    example/example.cpp
    )

# we let cmake generate the export header
include(GenerateExportHeader)
generate_export_header(example)
